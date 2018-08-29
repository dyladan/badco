(ns badco.skills
  (:require [cljs.nodejs :as n]
            [taoensso.timbre :as log]
            [badco.skills.weatherman :as weatherman]))

(def skills {"weather" weatherman/skill})

(defn alexa
  [body]
  (let [skill-id (aget body
                      "context"
                      "System"
                      "application"
                      "applicationId")
        skill (get skills skill-id)]
    ((get skill "IntentRequest"))))

