(ns playground.become-a-chef.views.become-a-chef
  (:require
   ["@mui/material" :refer [Box Card CardContent CardMedia Grid ThemeProvider
                            Typography]]
   [playground.components.page-nav :refer [page-nav]]
   [playground.router :as router]
   [playground.theme :refer [cards]]
   [re-frame.core :as rf]))
   ;; [playground.become-a-chef.views.agreement :refer [agreement]]
   ;; ["@mui/icons-material/CheckCircle" :default CheckCircleIcon]))

(defn become-a-chef
  []
  (let [steps [{:img "/img/curso.jpeg"
                :header "Cursos"
                :sub-header "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ut consequat enim, eget posuere tortor. Phasellus pretium hendrerit ornare. Etiam vitae ex in lectus dapibus pharetra ut ac massa. Pellentesque tincidunt suscipit dignissim. Suspendisse vestibulum blandit pretium."
                :href (router/path-for :recipes)
                :dispatch #(rf/dispatch [:set-active-nav :recipes])}
               {:img "/img/consultoria.jpeg"
                :header "Consultoria"
                :sub-header "Vivamus sagittis quam et metus egestas faucibus. In sit amet consequat enim. Sed vel lorem sagittis, fringilla ante sagittis, convallis lacus. Sed eu tellus fringilla, finibus libero quis, varius ex. Aenean tempus finibus enim. Aliquam erat volutpat. Fusce mollis blandit auctor."
                :href (router/path-for :sign-up)
                :dispatch #(rf/dispatch [:set-active-nav :sign-up])}
               {:img "/img/comercializacao-exportacao.jpeg"
                :header "Comercialização e Exportação"
                :sub-header "Proin lacinia vitae ante nec laoreet. Etiam id tempus urna, in vehicula metus. Aliquam ac rutrum sapien, vel efficitur arcu. Nullam in enim ut enim vehicula sagittis. Sed tristique, orci sed tristique scelerisque, neque urna porta enim, eu feugiat risus est sed sem."
                :href (router/path-for :log-in)
                :dispatch #(rf/dispatch [:set-active-nav :log-in])}]]

    [:> ThemeProvider {:theme cards}
      [:> Box
       [page-nav {:center "Expedição Café"}]
       [:> Grid {:container true
                 :direction "row"
                 :mb 3}
        [:> Grid {:item true
                  :xs 6
                  :display "flex"
                  :justify-content "center"
                  :align-items "center"}
         [:> Card {:sx {:background-color "inherit"}
                   :variant "plain"}
          [:> CardMedia {:component "img"
                         :sx {:max-width 700
                              :max-height 700
                              :border-radius "100%"
                              :box-shadow 4}
                         :class-name "rounded-full"
                         :image "./img/foto1.jpg"
                         :alt "Hand holding a cup of coffee"}]
          [:> CardContent {:variant "body2"
                           :sx {:max-width 700}}
           [:> Typography {:variant "h2"
                           :mb 1
                           :sx {:text-decoration "underline"
                                :font-style "bold"}}
            "Quem somos"]
           [:> Typography {:variant "p"
                           :font-size "1.3rem"
                           :color "text.secondary"}
            "Proin blandit nulla eu justo ornare pulvinar. Phasellus ornare, lectus at vehicula molestie, lacus tortor vulputate lectus, sit amet viverra urna sem eu felis. Quisque varius accumsan nisi, ut finibus lorem condimentum eu."]]]]

        [:> Grid {:item true
                  :xs 6
                  :display "flex"
                  :sx {:flex-direction "column"}
                  :gap 3
                  :justify-content "flex-start"}
         (for [{:keys [img alt header sub-header href dispatch]} steps]
           ^{:key header}
           [:a {:href href
                :on-click dispatch}
            [:> Card {:sx {:max-width "85%"
                           :box-shadow 4
                           "&:hover" {:background-color "primary.light"
                                       :box-shadow 15}
                           :as "a"}}
             [:> CardMedia
              {:component "img"
               :sx {:height "15em"}
               :image img
               :alt header}]
             [:> CardContent
              [:> Typography {:variant "h5"}
                             header]
              [:> Typography {:variant "body2" :color "text.secondary"} sub-header]]]])]]]]))
