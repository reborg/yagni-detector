(ns net.reborg.yagni.config
  (:require [clojure.java.io :as io]
            [clojure.pprint :as pp]
            [clojure.edn :as edn]))

(defn- load-edn [fname]
  (some->> fname
           (io/resource)
           (slurp)
           (edn/read-string)))

(defn- which-env []
  (or (System/getenv "YAGNI_ENV")
      (System/getProperty "yagni.env")
      "local"))

(defn- user-cfg-location [main-cfg]
  (str (System/getProperty "user.dir") "/"
       (or (:user-config main-cfg) "test/yagni.config")))

(defn- config []
  (let [main-cfg (load-edn (str "config." (which-env)))
        user-cfg (edn/read-string (slurp (user-cfg-location main-cfg)))]
    (merge main-cfg user-cfg)))

(defn matchers [] (:matchers (config)))
