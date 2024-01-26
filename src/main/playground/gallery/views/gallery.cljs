(ns playground.gallery.views.gallery
  (:require
   ["@mui/material" :refer [Box Button Grid Typography]]
   [playground.components.page-nav :refer [page-nav]]
   [playground.router :as router]
   [re-frame.core :as rf]
   [reagent.core :as r]))

;; <div class="grid gap-4">
;;     <div>
;;         <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/featured/image.jpg" alt="">
;;     </div>
;;     <div class="grid grid-cols-5 gap-4">
;;         <div>
;;             <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/square/image-1.jpg" alt="">
;;         </div>
;;         <div>
;;             <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/square/image-2.jpg" alt="">
;;         </div>
;;         <div>
;;             <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/square/image-3.jpg" alt="">
;;         </div>
;;         <div>
;;             <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/square/image-4.jpg" alt="">
;;         </div>
;;         <div>
;;             <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/square/image-5.jpg" alt="">
;;         </div>
;;     </div>
;; </div>
(defn item
  [src]
  [:div
   [:img {:class "h-auto max-w-full rounded-lg"
          :src src}]])

(defn gallery
  []
  [:> Grid {:container true
            :spacing 4
            :mt 2
            :mb 10}

   [page-nav {:center "Nossos Serviços"}]
   [:> Grid
    [:div {:class "grid gap-4"}
     [:div
      [:img {:class "h-auto max-w-full rounded-lg"
             :src "https://flowbite.s3.amazonaws.com/docs/gallery/featured/image.jpg"}]]
     [:div {:class "grid grid-cols-5 gap-4"}
       (let [items ["https://flowbite.s3.amazonaws.com/docs/gallery/square/image-1.jpg"
                    "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-2.jpg"
                    "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-3.jpg"
                    "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-4.jpg"
                    "https://flowbite.s3.amazonaws.com/docs/gallery/square/image-5.jpg"]]
         (for [src items]
            [item src]))]]]])
