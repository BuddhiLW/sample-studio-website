(ns playground.router
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as rf]))

(def routes ["/sample-studio-website/" {""                   :about-us
                                        "cursos/"           {"" :recipes
                                                             [:recipe-id] :recipe}
                                        "galeria"           :gallery
                                        "comercializacao"   :log-in}])
                  ;; "inbox/"            {"" :inboxes
                  ;;                      [:inbox-id] :inbox}
                  ;; "profile"           :profile
                  ;; "become-a-chef"     :become-a-chef
                  ;; "saved/"            :saved
                  ;; "stripe"            :stripe
                  ;; "upload-file"       :upload-file
                  ;; "free-paywall"      :free-paywall}])

(def history
  (let [dispatch #(rf/dispatch [:route-changed %])
        match #(bidi/match-route routes %)]
    (pushy/pushy dispatch match)))

(defn start!
  []
  (pushy/start! history))

(def path-for
  (partial bidi/path-for routes))

(defn set-token!
  [token]
  (pushy/set-token! history token))
