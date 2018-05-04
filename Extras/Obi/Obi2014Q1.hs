{-Questão 1. Para comemorar o aniversário de Cíntia, ela e mais quatro amigas – Alice, Bia, Dirce
e Eunice – foram almoçar juntas no restaurante da escola. As mesas são redondas e acomodam
exatamente cinco pessoas. Cíntia e Dirce sentam-se uma ao lado da outra. Alice e Bia não sentam-se
uma ao lado da outra. As duas amigas sentadas ao lado de Eunice são:
(A) Cíntia e Alice
(B) Cíntia e Dirce
(C) Alice e Bia
(D) Dirce e Bia
(E) Alice e Dirce
-}

questao1 :: String -> [String]
questao1 str = "Cintia":"Dirce":"Alice":str:"Bia":[]

{-De acordo com as regras a ordem de inserção não importa portanto desde que Cintia e Dirce estejam juntas, Alice e Bia
estejam separadas a pessoa restante deverá sentar entre elas.

>questao1 "Eunice"

retornará uma lista em que quem está ao lado de Eunice é a resposta
letra C é a Correta.
-}
