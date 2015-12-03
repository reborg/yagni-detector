(ns net.reborg.yagni
  (:require [clojure.tools.cli :refer [cli]]
            [net.reborg.yagni.config :as c])
  (:gen-class :main true))

(defn- avg [weights]
  (float (/ (reduce + weights) (count weights))))

(defn- detect [fname]
  (let [ftext (slurp fname)]
    (->> (keys (c/matchers))
         (map #(re-find (re-pattern %) ftext))
         (map #((c/matchers) %))
         (remove nil?)
         avg)))

(def options [ ["-t" "--test" "just echoes the argument list and exits" :flag true] ])

(defn mandatory-args? [args]
  (> (count (remove #(= "" %) args)) 0))

(defn print-msg-and-exit [msg]
  (do (println msg) (System/exit 1)))

(defn -main [& args]
  (let [[opts args banner] (apply cli args options)]
    (if (:test opts)
      (print-msg-and-exit (str " Args echo: " (seq args) "\n(To mesure JVM startup time just prepend 'time' to this command.)")))
    (if-not (mandatory-args? args)
      (print-msg-and-exit (str "Missing target plain text file for analysis. Usage: yagni [-t] awesome-file.txt" banner))
      (println (format "YAGNI coefficient for %s (0-10): %s" (first args) (detect (first args)))))))
