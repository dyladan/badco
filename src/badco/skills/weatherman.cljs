(ns badco.skills.weatherman)

(defn invoke
  "Get a bad weather forecast"
  []
  (str (rand-nth [
    "Eh, I don't know. Maybe rain?"
    "It looks cloudy here, but I'm not sure."])))
