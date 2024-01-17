(ns playground.db
  (:require
   [playground.auth.events]
   [playground.spec :refer [check-spec-interceptor]]
   [re-frame.core :as rf]))

(def initial-app-db {
                     :auth    {:uid nil}
                     :errors  {}
                     :inboxes {}
                     :files {:path nil}
                     :nav     {:active-page   :recipes
                               :active-nav    :recipes
                               :active-menu   false
                               :active-modal  nil
                               :active-recipe nil
                               :active-inbox  nil}
                     :recipes {}
                     :users   {"mike@mailinator.com" {:uid     "mike@mailinator.com"
                                                      :profile {:first-name "Mike"
                                                                :last-name  "Jordan"
                                                                :img        "https://res.cloudinary.com/schae/image/upload/f_auto,h_400,q_80/v1548196567/cheffy/mike.jpg"
                                                                :email      "mike@mailinator.com"
                                                                :password   "password"}
                                                      :role    :user
                                                      :saved   #{}
                                                      :inboxes {"jade@mailinator.com" {:id            :inbox-01
                                                                                       :updated-at    1538697210534
                                                                                       :notifications 3}
                                                                "mark@mailinator.com" {:id            :inbox-02
                                                                                       :notifications 6
                                                                                       :updated-at    1538697210537}}}
                               "jade@mailinator.com" {:uid     "jade@mailinator.com"
                                                      :profile {:first-name "Jade"
                                                                :last-name  "Miller"
                                                                :img        "https://res.cloudinary.com/schae/image/upload/f_auto,q_80/v1548196567/cheffy/jade.jpg"
                                                                :email      "jade@mailinator.com"
                                                                :password   "password"}
                                                      :role    :user
                                                      :saved   #{}
                                                      :inboxes {"mike@mailinator.com" {:id            :inbox-01
                                                                                       :updated-at    1538697210534
                                                                                       :notifications 3}}}
                               "mark@mailinator.com" {:uid     "mark@mailinator.com"
                                                      :profile {:first-name "Mark"
                                                                :last-name  "Slack"
                                                                :img        "https://res.cloudinary.com/schae/image/upload/f_auto,q_80/v1548196567/cheffy/mark.jpg"
                                                                :email      "mark@mailinator.com"
                                                                :password   "password"}
                                                      :role    :user
                                                      :saved   #{}
                                                      :inboxes {"mike@mailinator.com" {:id            :inbox-02
                                                                                       :notifications 6
                                                                                       :updated-at    1538697210537}}}}
                     :footer {:socials {:instagram "https://www.instagram.com/origenstattoopiercing/"
                                        :facebook "https://www.facebook.com/origenstattoobarber"}
                              :schedule {:days "De Segunda à Sexta"
                                         :hours "10h00m às 21h00m"
                                         :extra "Sábados, 10h00m às 15h00m"}
                              ;; Rua Santos Pereira, 185, Cidade Nova - Centro, Franca - SP, 14401-130
                              :address {
                                        :state "SP"
                                        :city "Franca"
                                        :block "Centro"
                                        :street "Rua Santos Pereira"
                                        :number "185"
                                        :cep "14401-130"
                                        :extra ""}
                              :google-maps {:src "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3736.3558449771936!2d-47.397720423884856!3d-20.5326163573583!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94b0a7cd38301727%3A0x3b9bd5719cb174fd!2sOrigens%20Tattoo%20Barber!5e0!3m2!1sen!2sbr!4v1705452511957!5m2!1sen!2sbr"}}})
                     

(rf/reg-event-fx
 :initialize-db
 [(rf/inject-cofx :local-store-user)
  check-spec-interceptor]
 (fn [{:keys [local-store-user]} _]
   {:db (assoc initial-app-db :auth local-store-user)}))

(comment
  {:auth {:uid     nil
          :errors  {}
          :inboxes {:inbox-01 {:participants #{"mike@mailinator.com" "jade@mailinator.com"}
                               :messages     [{:message    "first message"
                                               :author     "mike@mailinator.com"
                                               :created-at 1544614386378}
                                              {:message    "second message"
                                               :author     "jade@mailinator.com"
                                               :created-at 1544514356378}
                                              {:message    "third message"
                                               :author     "mike@mailinator.com"
                                               :created-at 1544414336378}
                                              {:message    "fourth message"
                                               :author     "mike@mailinator.com"
                                               :created-at 1544314316378}]}
                    :inbox-02 {:participants #{"mike@mailinator.com" "mark@mailinator.com"}
                               :messages     [{:message    "first message"
                                               :author     "mike@mailinator.com"
                                               :created-at 1544714386378}
                                              {:message    "second message"
                                               :author     "mark@mailinator.com"
                                               :created-at 1544614386378}
                                              {:message    "third message"
                                               :author     "mike@mailinator.com"
                                               :created-at 1544514386378}
                                              {:message    "fourth message"
                                               :author     "mike@mailinator.com"
                                               :created-at 1544414386378}]}}
          :nav     {:active-page   :recipes
                    :active-nav    :recipes
                    :active-modal  nil
                    :active-recipe nil
                    :active-inbox  nil}
          :recipes {:rec-01 {:id          :rec-01
                             :public?     false
                             :prep-time   30
                             :name        "Pesto Pasta"
                             :img         "https://res.cloudinary.com/schae/image/upload/f_auto,h_400,q_80/v1548183188/cheffy/recipes/pasta-pesto.jpg"
                             :saved-count 4
                             :ingredients {:ing-01 {:id      :ing-01
                                                    :order   1
                                                    :name    "Pasta"
                                                    :amount  250
                                                    :measure "gram"}
                                           :ing-02 {:id      :ing-02
                                                    :order   2
                                                    :name    "Tomatoes"
                                                    :amount  100
                                                    :measure "gram"}
                                           :ing-03 {:id      :ing-03
                                                    :order   3
                                                    :name    "Pesto"
                                                    :amount  150
                                                    :measure "gram"}
                                           :ing-04 {:id      :ing-04
                                                    :order   4
                                                    :name    "Lettuce"
                                                    :amount  100
                                                    :measure "gram"}}
                             :steps       {:step-01 {:id    :step-01
                                                     :order 1
                                                     :desc  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras massa orci, imperdiet sit amet ultricies vitae, consectetur nec est. Proin laoreet odio elit, vel rutrum tortor finibus non. Etiam auctor lorem eget diam sollicitudin condimentum. Nam quis posuere diam. Nulla vel arcu ac eros vestibulum accumsan in quis eros."}

                                           :step-02 {:id    :step-02
                                                     :order 2
                                                     :desc  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras massa orci, imperdiet sit amet ultricies vitae, consectetur nec est. Proin laoreet odio elit, vel rutrum tortor finibus non. Etiam auctor lorem eget diam sollicitudin condimentum. Nam quis posuere diam. Nulla vel arcu ac eros vestibulum accumsan in quis eros."}
                                           :step-03 {:id    :step-03
                                                     :order 3
                                                     :desc  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras massa orci, imperdiet sit amet ultricies vitae, consectetur nec est. Proin laoreet odio elit, vel rutrum tortor finibus non. Etiam auctor lorem eget diam sollicitudin condimentum. Nam quis posuere diam. Nulla vel arcu ac eros vestibulum accumsan in quis eros."}
                                           :step-04 {:id    :step-04
                                                     :order 4
                                                     :desc  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras massa orci, imperdiet sit amet ultricies vitae, consectetur nec est. Proin laoreet odio elit, vel rutrum tortor finibus non. Etiam auctor lorem eget diam sollicitudin condimentum. Nam quis posuere diam. Nulla vel arcu ac eros vestibulum accumsan in quis eros."}
                                           :step-05 {:id    :step-05
                                                     :order 5
                                                     :desc  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras massa orci, imperdiet sit amet ultricies vitae, consectetur nec est. Proin laoreet odio elit, vel rutrum tortor finibus non. Etiam auctor lorem eget diam sollicitudin condimentum. Nam quis posuere diam. Nulla vel arcu ac eros vestibulum accumsan in quis eros."}}
                             :cook  "mike@mailinator.com"
                             :price 3900}
                    :rec-02 {:id          :rec-02
                             :prep-time   45
                             :public?     true
                             :name        "Splitony's Pizza"
                             :img         "https://res.cloudinary.com/schae/image/upload/f_auto,h_400,q_80/v1548183465/cheffy/recipes/pizza.jpg"
                             :saved-count 5
                             :ingredients {:ing-01 {:id      :ing-01
                                                    :name    "Pizza dough"
                                                    :amount  350
                                                    :measure "gram"}
                                           :ing-02 {:id      :ing-02
                                                    :name    "Tomatoe sauce"
                                                    :amount  100
                                                    :measure "gram"}
                                           :ing-03 {:id      :ing-03
                                                    :name    "Shraded Mozarella"
                                                    :amount  250
                                                    :measure "gram"}
                                           :ing-04 {:id      :ing-04
                                                    :name    "Olives"
                                                    :amount  50
                                                    :measure "gram"}
                                           :ing-05 {:id      :ing-05
                                                    :name    "Onions"
                                                    :amount  50
                                                    :measure "gram"}
                                           :ing-06 {:id      :ing-06
                                                    :name    "Red & Green Peppers"
                                                    :amount  100
                                                    :measure "grams"}}
                             :steps       {:step-01 {:id    :step-01
                                                     :order 1
                                                     :desc  "First step"}
                                           :step-02 {:id    :step-02
                                                     :order 2
                                                     :desc  "Second step"}
                                           :step-03 {:id    :step-03
                                                     :order 3
                                                     :desc  "Third step"}
                                           :step-04 {:id    :step-04
                                                     :order 4
                                                     :desc  "Fourth step"}
                                           :step-05 {:id    :step-05
                                                     :order 5
                                                     :desc  "Fifth step"}}
                             :cook        "mike@mailinator.com"
                             :price       3400}
                    :rec-03 {:id          :rec-03
                             :prep-time   15
                             :public?     false
                             :name        "Pancakes"
                             :img         "https://res.cloudinary.com/schae/image/upload/f_auto,h_400,q_80/v1548184422/cheffy/recipes/oatmeal-pancakes.jpg"
                             :saved-count 5
                             :ingredients {:ing-01 {:id      :ing-01
                                                    :name    "whites"
                                                    :amount  3
                                                    :measure "egg"}
                                           :ing-02 {:id      :ing-02
                                                    :name    "whole"
                                                    :amount  1
                                                    :measure "egg"}
                                           :ing-03 {:id      :ing-03
                                                    :name    "Oatmeal"
                                                    :amount  1
                                                    :measure "cup"}
                                           :ing-04 {:id      :ing-04
                                                    :name    "Banana"
                                                    :amount  1
                                                    :measure "medium"}
                                           :ing-05 {:id      :ing-05
                                                    :name    "Cocount oil"
                                                    :amount  1
                                                    :measure "spoon"}
                                           :ing-06 {:id      :ing-06
                                                    :name    "Flax seeds"
                                                    :amount  2
                                                    :measure "table spoons"}}
                             :steps       {:step-01 {:id    :step-01
                                                     :order 1
                                                     :desc  "Preheat a pan on mid-high"}
                                           :step-02 {:id    :step-02
                                                     :order 2
                                                     :desc  "Put all ingredients into a blender and mix until creamy - 30 seconds should be enough"}
                                           :step-03 {:id    :step-03
                                                     :order 3
                                                     :desc  "Pour mix onto the hot pan and cover with a lid"}
                                           :step-04 {:id    :step-04
                                                     :order 4
                                                     :desc  "Cook for 5-10 minutes and flip to the other side - the lid is your friend. Cook for another 3-5 minutes"}
                                           :step-05 {:id    :step-05
                                                     :order 4
                                                     :desc  "Serve hot with marmalaids, honey, syrup, peanut butter etc."}}
                             :cook        "jade@mailinator.com"
                             :price       1900}
                    :rec-04 {:id          :rec-04
                             :prep-time   15
                             :public?     true
                             :name        "Avocado Salad"
                             :img         "https://res.cloudinary.com/schae/image/upload/f_auto,h_400,q_80/v1548183354/cheffy/recipes/vegie-salad.jpg"
                             :saved-count 5
                             :ingredients {:ing-01 {:id      :ing-01
                                                    :name    "Eggs"
                                                    :amount  2
                                                    :measure ""}
                                           :ing-02 {:id      :ing-02
                                                    :name    "Milk"
                                                    :amount  100
                                                    :measure "Mililiters"}
                                           :ing-03 {:id      :ing-03
                                                    :name    "Yeast"
                                                    :amount  10
                                                    :measure "gram"}}
                             :steps       {:step-01 {:id    :step-01
                                                     :order 1
                                                     :desc  "First step"}
                                           :step-02 {:id    :step-02
                                                     :order 2
                                                     :desc  "Second step"}
                                           :step-03 {:id    :step-03
                                                     :order 3
                                                     :desc  "Third step"}
                                           :step-04 {:id    :step-04
                                                     :order 4
                                                     :desc  "Fourth step"}
                                           :step-05 {:id    :step-05
                                                     :order 5
                                                     :desc  "Fifth step"}}
                             :cook        "jade@mailinator.com"
                             :price       2900}
                    :rec-05 {:id          :rec-05
                             :prep-time   15
                             :public?     true
                             :name        "Banana Waffles"
                             :img         "https://res.cloudinary.com/schae/image/upload/c_scale,f_auto,h_400,q_80/v1548162102/cheffy/recipes/banana-oatmeal-waffles.jpg"
                             :saved-count 8
                             :ingredients {:ing-01 {:id      :ing-01
                                                    :name    "whites"
                                                    :amount  3
                                                    :measure "egg"}
                                           :ing-02 {:id      :ing-02
                                                    :name    "whole"
                                                    :amount  1
                                                    :measure "egg"}
                                           :ing-03 {:id      :ing-03
                                                    :name    "Oatmeal"
                                                    :amount  1
                                                    :measure "cup"}
                                           :ing-04 {:id      :ing-04
                                                    :name    "Banana"
                                                    :amount  1
                                                    :measure "medium"}
                                           :ing-05 {:id      :ing-05
                                                    :name    "Cocount oil"
                                                    :amount  1
                                                    :measure "spoon"}
                                           :ing-06 {:id      :ing-06
                                                    :name    "Almonds"
                                                    :amount  0.5
                                                    :measure "cup"}}
                             :steps       {:step-01 {:id    :step-01
                                                     :order 1
                                                     :desc  "Preheat waffle iron"}
                                           :step-02 {:id    :step-02
                                                     :order 2
                                                     :desc  "Blend all the ingredients"}
                                           :step-03 {:id    :step-03
                                                     :order 3
                                                     :desc  "Pour mix onto hot waffle iron and wait until ready"}
                                           :step-04 {:id    :step-04
                                                     :order 4
                                                     :desc  "Serve hot with marmalaids, honey, syrup, peanut butter etc."}}
                             :cook        "jade@mailinator.com"
                             :price       2900}}
          :users {"mike@mailinator.com" {:uid     "mike@mailinator.com"
                                         :profile {:first-name "Mike"
                                                   :last-name  "Jordan"
                                                   :img        "https://res.cloudinary.com/schae/image/upload/f_auto,h_400,q_80/v1548196567/cheffy/mike.jpg"
                                                   :email      "mike@mailinator.com"
                                                   :password   "password"}
                                         :role    :user
                                         :saved   #{}
                                         :inboxes {"jade@mailinator.com" {:id            :inbox-01
                                                                          :updated-at    1538697210534
                                                                          :notifications 3}
                                                   "mark@mailinator.com" {:id            :inbox-02
                                                                          :notifications 6
                                                                          :updated-at    1538697210537}}}
                  "jade@mailinator.com" {:uid     "jade@mailinator.com"
                                         :profile {:first-name "Jade"
                                                   :last-name  "Miller"
                                                   :img        "https://res.cloudinary.com/schae/image/upload/f_auto,q_80/v1548196567/cheffy/jade.jpg"
                                                   :email      "jade@mailinator.com"
                                                   :password   "password"}
                                         :role    :user
                                         :saved   #{}
                                         :inboxes {"mike@mailinator.com" {:id            :inbox-01
                                                                          :updated-at    1538697210534
                                                                          :notifications 3}}}
                  "mark@mailinator.com" {:uid     "mark@mailinator.com"
                                         :profile {:first-name "Mark"
                                                   :last-name  "Slack"
                                                   :img        "https://res.cloudinary.com/schae/image/upload/f_auto,q_80/v1548196567/cheffy/mark.jpg"
                                                   :email      "mark@mailinator.com"
                                                   :password   "password"}
                                         :role    :user
                                         :saved   #{}
                                         :inboxes {"mike@mailinator.com" {:id            :inbox-02
                                                                          :notifications 6
                                                                          :updated-at    1538697210537}}}}}})

;; LOCALIZAÇÃO GOOGLE MAPS
;; https://www.google.com/maps/dir//origens+tattoo+e+piercing/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x94b0a7cd38301727:0x3b9bd5719cb174fd?sa=X&ved=2ahUKEwjhjNyTps-DAxXJqpUCHeOxDU8Q9Rd6BAhFEAA
;; Instagram estudio: https://www.instagram.com/origenstattoopiercing/
;; Instagem:https://www.instagram.com/origenstattoopiercing/
;; Facebook:https://www.facebook.com/origenstattoobarber
;; 
;; Whatsapp: 
;; RafaelAndrad: https://api.whatsapp.com/send?phone=5516981313890&text=Ol%C3%A1!%20Gostaria%20de%20fazer%20um%20or%C3%A7amento%20com%20o%20Rafael%20Andrade%20Tattoo.
;; Pedro Nob: https://api.whatsapp.com/send?phone=5516981313890&text=Ol%C3%A1!%20Gostaria%20de%20fazer%20um%20or%C3%A7amento%20com%20o%20Rafael%20Andrade%20Tattoo.
;; Tacio Lobato: https://api.whatsapp.com/send/?phone=5516997219901&text&type=phone_number&app_absent=0
;; Luciano Duarte: https: //l.instagram.com/?u=https%3A%2F%2Fwa.me%2F5516993510565&e=AT0NzhFsYI5Mr1NoN4Tvr-nu-EdvPGPAhh7peOQYBaFJwy5e0M-75psAhuNqihiuUtsNLdMfxrUKv1iPy585jE0QElz1VqPqkbVQR6wxoPGUKDIa0XARNA
;; Patrik Bonacio: https://wa.me/5516994605806
;; 
;; Instagram: 
;; Rafael Andrade:https://www.instagram.com/rafaandradetattoo/
;; Pedro Nób: https://www.instagram.com/pedro_nob_016/
;; Tacio Lobato: https://www.instagram.com/tacio_lobato/  
;; Luciano Duarte https://www.instagram.com/lucianoduarteoficialtattoo?igsh=MTlid2lyNW9zNTJ6cg==
;; Patrik Bonacio: https://www.instagram.com/bonacinitattoo?igsh=eDQyOXV6cXB3OGJt
;; 
;; hr de funcionamento 
;; seg - sex: 10:00 - 21:00
;; sab. 10:00 - 15:00
;; Domingo fechado
