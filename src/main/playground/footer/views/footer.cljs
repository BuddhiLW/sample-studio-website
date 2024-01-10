(ns playground.footer.views.footer
  (:require
   [playground.theme :refer [footer-theme]]
   ["@mui/material" :refer [Grid Box Typography Link BottomNavigation ThemeProvider]]))

(defn footer []
  [:> ThemeProvider {:theme footer-theme}
   [:> Grid {:sx {:background-color "primary.contrast"}}
    [:> Box {:sx {:background-color "primary.main"}
             :py "1rem"
             :mt "1rem"}
     [:> Typography {:variant "body1"
                     :align "center"}

      "De Segunda à Sexta, 8h00m às 16h00m"]
     [:> Typography {:variant "body2"
                     :align "center"}
      "Rua Diogo Feijó, 1682- Sala 1; Estação, Franca - SP"
      [:br]
      "14405-212"]]
    [:> Box {:sx {:display "flex"}
             :my 2
             :py 2
             :align-items "center"
             :justify-content "center"}
           [:iframe
             {:src "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2439.756582499744!2d-47.41310036078449!3d-20.536649156893812!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94b0a70e096eb103%3A0xa85a9b2c46bcccc6!2zRXhwZWRpw6fDo28gQ2Fmw6kgQ29tw6lyY2lvIGUgQ29uc3VsdG9yaWE!5e1!3m2!1sen!2sbr!4v1704490540492!5m2!1sen!2sbr"
              :width "500 em"
              :height "200 em"
              :style {:border "0"}
              :allowfullscreen ""
              :loading "lazy"
              :referrerpolicy "no-referrer-when-downgrade"}]]]
   [:> Box {:sx {:background-color "primary.main"}
            :py "1rem"
            :mt "1rem"}
     [:> BottomNavigation {:showLabels true
                               :sx {:background-color "primary.main"
                                    :margin "0 auto"
                                    :font-size "2.5em"
                                    :my 0.2
                                    :display "flex"
                                    :justify-content "space-evenly"
                                    :max-width 200}}
           [:i {:class "fa-brands fa-instagram"}]
           [:i {:class "fa-brands fa-facebook"}]
           [:i {:class "fa-solid fa-envelope"}]]
     [:> Typography {:variant "body2"
                     :align "center"}
      "© 2024 Expedição Café. Todos os direitos reservados."]]])
    


    
     ;; <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2439.756582499744!2d-47.41310036078449!3d-20.536649156893812!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94b0a70e096eb103%3A0xa85a9b2c46bcccc6!2zRXhwZWRpw6fDo28gQ2Fmw6kgQ29tw6lyY2lvIGUgQ29uc3VsdG9yaWE!5e1!3m2!1sen!2sbr!4v1704490540492!5m2!1sen!2sbr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
