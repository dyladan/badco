(defproject badco "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.339"]

                 ; logging
                 [com.taoensso/timbre "4.10.0"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :source-paths ["src"]

  :clean-targets ["target" "express.js" "lambda.js"]

  :cljsbuild {:builds [{:id "express"
                        :source-paths ["src"]
                        :compiler {:target :nodejs
                                   :output-to "express.js"
                                   :output-dir "target/js/compiled/express"
                                   :main badco.express
                                   :parallel-build true
                                   :optimizations :none}}
                       {:id "lambda"
                        :source-paths ["src"]
                        :compiler {:target :nodejs
                                   :output-to "lambda.js"
                                   :output-dir "target/js/compiled/lambda"
                                   :main badco.lambda
                                   :parallel-build true
                                   :optimizations :none}}]})
