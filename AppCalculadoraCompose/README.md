1. O que é entrada em um sistema computacional? Dê dois exemplos.
R: É toda a informaçãop fornecida ao sistema. Um sensor que retorna dados, um usuario fazendo cadastro etc.

2. Qual é a diferença entre processamento e saída?
R: O processamento é onde os dados de entrada passam por um conjunto de operações executadas, enquanto a saida é o resultado desse processamento.

3. Por que o valor digitado em um TextField é inicialmente tratado como texto?
R: Porque o campo apresenta flexibilidade, arquitetura de estado e comportamento de UI. Por exemplo, se você utiliza um campo int ou float, caracteres como - podem quebrar a aplicação.

4. Qual é a finalidade de remember e mutableStateOf?
R: O mutableStateOf cria um estado observável, quando seu valor muda, o compose identifica que os elementos dele podem precisar ser atualizados.
O remember mantém o valor durante recomposições da função Composable.

5. O que é um evento? Cite os eventos utilizados nesta aplicação.
R: É algo que acontece durante a interação. onValueChange e onClick

6. O que significa recomposição no Jetpack Compose?
R: É o processo onde o Compose reexecuta as funções Composable necessárias para refletir mudanças de estado

7. Qual é a responsabilidade da MainActivity neste projeto?
R: É iniciar o conteúdo Compose e chamar a função que representa a interface.

8. Qual é a responsabilidade de CalculadoraDescontoScreen?
R: Contém os componentes visuais, mantém os estados necessários, recebe eventos e coordena a chamada à regra de negócio. Ela apresenta o resultado.

9. Por que calcularPrecoComDesconto foi colocada em outro arquivo?
R: Pois estamos utilizando a organização doo aplicativo no nível 3.

10. Qual é a vantagem de uma função de regra de negócio não depender do Compose?
R: A principal vantagem é a testabilidade, o desacoplamento e a manutenibilidade.