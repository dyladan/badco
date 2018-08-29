(ns badco.express
  (:require [cljs.nodejs :as n]
            [taoensso.timbre :as log]
            [badco.skills :as skills]))

(def app ((n/require "express")))

(if (= (aget js/process "env" "NODE_ENV") "production")
  (.use app (n/require "alexa-verifier-middleware")))

(defn alexa
  "Dispatch incoming calls to the alexa skill handler"
  [req res]
  (.send res (skills/alexa (.-body req))))

(defn server-started-callback
  "Callback triggered when ExpressJS server has started"
  [req]
  (log/info "App started on port: 3000"))

(defn -main
  "Application startup"
  [& args]
  (doto app
    ; (.use (n/require "alexa-verifier-middleware"))
    (.use (.json (n/require "body-parser")))
    (.post "/alexa" alexa)
    (.listen 3000  server-started-callback)))

(set! *main-cli-fn* -main)

