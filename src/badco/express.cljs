(ns badco.express
  (:require [cljs.nodejs :as n]
            [taoensso.timbre :as log]
            [badco.skills.weatherman :as weatherman]))

(def json (.-json (n/require "body-parser")))

(def app ((n/require "express")))

(defn handler
  "doc"
  [req res]
  (. res (send (weatherman/invoke))))

(defn server-started-callback
  "Callback triggered when ExpressJS server has started"
  [req]
  (log/info "App started on port: 3000"))

(defn request-logger
  "Log all POST requests"
  [req res next]
  (log/info "POST received")
  (next))

(defn -main
  [& args]
  (doto app
    (.use (json))
    (.post "/" handler)
    (.listen 3000  server-started-callback)))

(set! *main-cli-fn* -main)
