(*Programa em Ocaml que resolve fatorial abordando uma forma diferente dos tutoriais da internet usando listas*)
let mul x y = x * y;;
let rec crialist x = if x <= 1 then x::[] else x::crialist (x-1);;
let fatorial x = List.fold_left mul 1 (crialist x);;

(*Versão usando lambda:*)
let rec crialist x = if x <= 1 then x::[] else x::crialist (x-1);;
let fatorial x = List.fold_left (fun x y -> x*y) 1 (crialist x);;

/*Para executar as funçoes coloque cada uma no interpretador e depois diga o nome da função com seus argumentos.
  Exemplo# fatorial 5;; */

/*Em Ocaml ao contrário da função List.map(semelhante ao 'map' do Haskell) que executa uma função dentro de cada elemento de uma 
  lista e retorna outra lista a função List.fold_left usa tres argumentos:
  1º argumento: uma função a qual deve ser aplicada entre o 2º argumento e cada elemento do 3º argumento que é uma lista.
  2º argumento: um valor inicial, pode servir também como elemento de teste ou de partida.
  3º argumento: uma lista de elementos(os elementos dessa lista nao necessariamente precisam ser do mesmo tipo do 2º argumento,
  mas caso não sejam deve-se ficar atento a isso, para as devidas conversões de tipo) podendo variar o tipo de dados.
  Na execução após aplicar a função(1º argumento) com o primeiro elemento da lista(3º argumento) com o valor inicial(2º argumento),
  o segundo elemento da lista usará o resultado do primeiro para reaplicar a função.
  Para simplificar veja os exemplos mais elementares:
  
  List.fold_left (+) 0 [1; 2; 3; 4];;
  saída:
  -: int = 10;
  
  O que o exemplo acima fez, foi somar o valor 0 com o 1 depois soma o 2 com o resultado da primeira soma e assim sucessivamente
  até o final da lista.
  Outro exemplo:
  
  List.fold_left (^) "/" ["Denes "; "Vargas "; "Teixeira"];;
  saída: 
  -: string = "/Denes Vargas Teixeira"
  
  Como pode ser notado nesse exemplo acima, não necessita ser numeros para usa-la, além disso ela utiliza o segunto argumento
  apenas como valor inicial para aplicar a função ao elemento mais a esquerda da lista e depois aplicar ao resto da lista.
  
  Embora o programa de fotorial tenha diversas outras formas de ser feito, a proposta em si era tentar usar outras ferramentas
  de uma linguagem não vista em aula, focando na didática, sem contar que para chegar a tais resultados um estudo prévio sobre
  a linguagem fez-se necessário, em conjunto disso pode-se relacionar outra linguagem funcional com a estudada em aula e perceber
  suas semelhanças e diferenças.
  A linguagem Ocaml é muito semelhante a linguagem Haskell pois ambas são funcionais e fortemente tipadas. Os testes das funções
  em Ocaml foram feitos no interpretador online da linguagem disponível em: https://try.ocamlpro.com/
  Material didático da linguagem disponível em: https://ocaml.org/learn/tutorials/
  */

