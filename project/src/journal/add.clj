(ns journal.add
  (:require
   [journal.utils :as utils]))

(defn add-entry
  [{:keys [opts]}]
  (let [entries (utils/read-entries)]
    (spit utils/ENTRIES-LOCATION
          (conj entries
                (merge {:timestamp (System/currentTimeMillis)} ;; default timestamp
                       opts)))))
