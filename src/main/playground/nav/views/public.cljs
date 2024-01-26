(ns playground.nav.views.public
  (:require
   ["@mui/material" :refer [Box Container AppBar IconButton MenuItem Button Typography Toolbar]]
   ["@mui/icons-material" :as mui-icons]
   [playground.nav.views.nav-item :refer [box]]
   [playground.router :as router]
   [re-frame.core :as rf]))

(defn handle-open-nav-menu
  [])
  

(defn handle-close-nav-menu [dispatch]
  (rf/dispatch [:set-open-nav-menu false])
  dispatch)

#_(defn drop-menu [nav-items]
    (fn []
      (if @(rf/subscribe [:nav/active-menu])
        [:> Box {:display "flex"
                 :flex-direction "column"
                 :background-color "primary.black"}
           (for [{:keys [id name href dispatch]} nav-items]
             ^{:key id}
             [:> Button {:href href}
               [:> MenuItem {:on-click #(handle-close-nav-menu dispatch)}
                [:> Typography {:text-align "center"} name]]])]
        [:div])))

(defn public
  []
  (let [active-page @(rf/subscribe [:active-page])
        nav-items [{:id :about-us
                    :name "Sobre"
                    :href (router/path-for :about-us)
                    :dispatch #(rf/dispatch [:set-active-nav :about-us])}
                   {:id :recipes
                    :name "Profissionais"
                    :href (router/path-for :recipes)
                    :dispatch #(rf/dispatch [:set-active-nav :recipes])}
                   {:id :sign-up
                    :name "Galeria"
                    :href (router/path-for :gallery)
                    :dispatch #(rf/dispatch [:set-active-nav :gallery])}
                   #_{:id :log-in
                      :name "Comercialização"
                      :href (router/path-for :log-in)
                      :dispatch #(rf/dispatch [:set-active-nav :log-in])}]]
     [:<>
       ;; [drop-menu nav-items]
       [:> AppBar {:position "static"}
        [:> Container {:py 1}
         [:> Toolbar {:disable-gutters true
                       :sx {:display "flex"
                            :justify-content "center"
                            :flex-wrap "wrap"}}
          #_[:> Button {:on-click #(rf/dispatch [:set-open-nav-menu true])}
              [:> IconButton {:sx {:display { :xs "flex", :md "none"}}}
                 [:> mui-icons/Menu]]]
          (for [{:keys [id name href dispatch]} nav-items]
            ^{:key id}
            [:> Box #_{:sx {:display "inline" #_{:xs "None"
                                                 :md "inline"}}}
             [box {:key id
                   :id id
                   :name name
                   :href href
                   :dispatch dispatch
                   :active-page active-page}]])]]]]))
      
      ;; [drop-menu nav-items]
      ;; [:div "not active"])])))
