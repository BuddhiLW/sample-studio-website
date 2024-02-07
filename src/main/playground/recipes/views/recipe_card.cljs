(ns playground.recipes.views.recipe-card
  (:require
   ["@mui/icons-material/AccessAlarm" :default AccessAlarm]
   ["@mui/icons-material/WhatsApp" :default WhatsApp]
   ["@mui/icons-material/Instagram" :default Instagram]
   ["@mui/material" :refer [Grid Paper Typography Card CardMedia CssBaseline IconButton]]
   ["@mui/material/styles" :refer [ThemeProvider]]
   [playground.router :as router]
   [playground.theme :refer [cards]]))

(defn recipe-card [recipe]
  (let [{:keys [name whatsapp instagram perfil id]} recipe]
    ^{:key id}
    [:> Grid {:px 2
              :py 2
              :sx {:max-width {:xs "75%"}
                   :justify-content "center"}}
     [:> Paper {:pb 4
                :sx {:box-shadow 3}
                :class-name "transition hover:shadow-2xl hover:drop-shadow-2xl hover:-translate-y-1 ease-in-out delay-150 duration-500"}
      [:> CssBaseline]
      [:> ThemeProvider {:theme cards}
       [:> Card {:p 2
                 :sx {:box-shadow 10}
                 :class-name "hover:shadow-2xl"}
        [:> CardMedia {:class "img-card"
                       :as "a"
                       :href (router/path-for :recipe :recipe-id id)
                       :sx {:height 300
                            :width 400}
                       :image (or (str "../../" perfil)
                                  (str "../../images/placeholder.jpg"))}]
        [:> Grid {:container true}
         [:> Grid {:item true :xs 12 :pt 2}
          [:> Typography {:variant "p"
                          :px 2
                          :class-name "text-3xl decoration-2 text-slate-700"}
           name]]]
        [:> Grid {:container true}
         [:> Grid {:item true
                   :p 2
                   :xs 7
                   :sx {:display "flex"
                        :flex-direction "row"
                        :align-items "center"}}
          [:> Grid {:container true
                    :sx
                    {:flex-direction "row"
                     :align-items "center"}}
           [:> IconButton {:on-click (fn [e] (.open js/window whatsapp))}
            [:> WhatsApp {:color "primary"
                          :sx {:font-size 45}}]]
           [:> IconButton {:on-click (fn [e] (.open js/window instagram))}
            [:> Instagram {:color "primary"
                           :sx {:font-size 45}}]]]]]]]]]))
