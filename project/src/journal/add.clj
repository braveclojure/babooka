(ns journal.add
  (:require
   [journal.utils :as utils]))

(defn add-entry
  [opts]
  (let [entries (utils/read-entries)]
    (spit utils/ENTRIES-LOCATION
          (conj entries
                (merge {:timestamp (System/currentTimeMillis)} ;; default timestamp
                       opts)))))



(ns journal.add
  (:require
   [journal.utils :as utils]))

(defn -main
  [entry-text]
  (let [entries (utils/read-entries)]
    (spit utils/ENTRIES-LOCATION
          (conj entries
                {:timestamp (System/currentTimeMillis)
                 :entry     entry-text}))))
