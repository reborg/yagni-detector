(defproject reborg.net/yagni-detector "0.0.4"
  :description "Because you just ain't gonna need it."
  :dependencies [[org.clojure/clojure "1.8.0-RC2"]
                 [org.clojure/tools.cli "0.3.1"]]
  :main net.reborg.yagni
  :uberjar-name "yagni.jar"
  :repl-options {:init (do
                         (require 'midje.repl)
                         (midje.repl/autotest :filter :core (complement :slow)))}
  :aliases {"midje-fast" ["midje" ":filter" "-slow"]}
  :profiles {:uberjar
             {:main net.reborg.yagni, :aot :all}
             :dev
             {:dependencies [[midje "1.6.3"]]
              :plugins [[lein-midje "3.1.3"]]}})
