(ns journal.list
  (:require
   [journal.utils :as utils]))

(defn list-entries
  [_]
  (let [entries (utils/read-entries)]
    (doseq [{:keys [timestamp entry]} (reverse entries)]
      (println timestamp)
      (println entry "\n"))))
