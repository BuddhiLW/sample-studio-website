(ns playground.recipes.views.recipe-image
  (:require
   ["@mui/material" :refer [Button Card CardMedia colors Grid]]
   [clojure.string :as str]
   [playground.components.form-group :refer [form-group]]
   [playground.components.modal :refer [modal]]
   [re-frame.core :as rf]
   [reagent.core :as r]))

(defn recipe-img []
  (let [{:keys [perfil name]} @(rf/subscribe [:recipes/recipe])]
    [:<>
     [:> Card {:p 2
               :sx {:box-shadow 10
                    :border-radius "10px"}
               :class-name "hover:shadow-2xl"}
      [:> CardMedia {:class-name "mx-auto"
                     :sx {:height {:xs 200
                                   :sm 400}
                          :width  {:xs 300
                                   :sm 500}}
                     :image (str (or (str "../../" perfil)
                                     "../img/placeholder.jpg"))
                     :alt name}]]]))
