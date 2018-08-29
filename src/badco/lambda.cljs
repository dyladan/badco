(ns badco.lambda
  (:require [cljs.nodejs :as n]
            [taoensso.timbre :as log]
            [badco.skills.weatherman :as weatherman]))

(defn handler
  [event ctx cb]
  (log/info (.stringify js/JSON event js/null 2))
  (log/info (weatherman/invoke)))

(set! (.-exports js/module) #js {:handler handler})

; (set! *main-cli-fn* -main)
