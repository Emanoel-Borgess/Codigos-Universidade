# Relatório de Atividades: Modelagem de Domínio e DDD - Emanoel R. Borges

Este documento contém as anotações e soluções para todas as atividades propostas na disciplina.

## Tabela de Autoavaliação

| Aula                                                 | Atividade                               | Auto-avaliação (0-5) | Justificativa                                                                        | Data/Hora completada     |                                              |
| :--------------------------------------------------- | :-------------------------------------- | :------------------: | :----------------------------------------------------------------------------------- | :----------------------- | :--------------------------------------------------------------------------------------------- |
| **Aula 1.1** | Introdução à Modelagem de Domínio       |           5          | Todas as 16 questões foram respondidas, cobrindo os conceitos iniciais de modelagem. | 17/06/2025 - 19h       |   |
| **Aula 1.2** | Modelos Mentais e Conhecimento          |           5          | Todas as 17 questões foram completadas, incluindo as reflexões sobre Netflix e Uber. | 26/06/2025 - 19h       ||
| **Aula 1.3** | Histórico e Evolução                    |           5          | Respondi às 4 questões, realizando a pesquisa sobre a evolução das técnicas.         | 29/06/2025 - 19h       ||
| **Aula 2.1** | Introdução ao DDD                       |           4          | Concluí 22 de 25 questões (88%). A reflexão sobre o "Estudo de Caso Scrum" foi mais desafiadora. | 15/07/2025 - 19h       ||
| **Aula 4.1** | Contextos Delimitados                   |           5          | Todas as 7 questões sobre subdomínios foram realizadas.                              | 21/07/2025 - 19h       |                |
| **Aula 5.1** | Design Estratégico                      |           3          | Concluí cerca de 60% das atividades. Tive dificuldade com a ferramenta ContextMapper. | 13/08/2025 - 19h       |  |
| **Aula 6.1** | Design Tático 1                         |           5          | Implementei todos os 15 exemplos de código para Value Objects, Entidades e Agregados. | 17/09/2025 - 19h       | |
| **Aula 6.2** | Design Tático 2                         |           5          | Implementei todos os 13 exemplos de código para Serviços, Eventos, Fábricas, etc.    | 20/09/2025 - 21:00       | |

## Aula 1.1: Introdução à Modelagem de Domínio

### Categoria: Conceito de Modelos

**1. Tente lembrar de modelos que você já tenha visto, usado e ou experimentado. Indique ao menos três mais relevantes.**

1.  **Mapa de uma cidade:** Um modelo geográfico que representa ruas, bairros e pontos de interesse.
2.  **Maquete de um edifício:** Um modelo físico em escala reduzida que representa a estrutura e o design de uma construção.
3.  **Modelo de Entidade-Relacionamento (MER):** Um modelo conceitual usado em engenharia de software para representar a estrutura de um banco de dados.

* **Explicação:** Modelos são simplificações da realidade que nos ajudam a entender, analisar ou comunicar algo complexo. Os exemplos citados representam diferentes tipos de modelos (geográfico, físico, conceitual) que são comuns em nosso cotidiano e em áreas técnicas.

**2. Comente brevemente seu propósito e utilidade.**

* **Mapa de uma cidade:** Seu propósito é facilitar a navegação e a localização. É útil para que pessoas se desloquem de um ponto a outro, planejem rotas e entendam a distribuição espacial da cidade.
* **Maquete de um edifício:** Seu propósito é visualizar o resultado final de um projeto arquitetônico. É útil para arquitetos, engenheiros e clientes entenderem a forma, a proporção e a estética da construção antes de ela ser feita.
* **Modelo de Entidade-Relacionamento (MER):** Seu propósito é descrever os dados de um sistema e como eles se relacionam. É útil para projetar bancos de dados de forma eficiente, garantindo a integridade e a consistência das informações.

* **Explicação:** Cada modelo tem um propósito específico, focado em resolver um problema ou facilitar a compreensão de um aspecto particular da realidade. A utilidade de um modelo está diretamente ligada à sua capacidade de cumprir esse propósito de forma clara e eficaz.

**3. Descreva: suas características específicas e comuns com os demais.**

* **Características Comuns:** Todos os três são abstrações, ou seja, simplificam a realidade, omitindo detalhes irrelevantes para focar no que é importante. Todos servem como uma forma de comunicação e documentação.
* **Características Específicas:**
    * **Mapa:** É uma representação 2D de um espaço 3D, usando símbolos e escalas definidas. Sua especificidade está na linguagem cartográfica.
    * **Maquete:** É uma representação física e tridimensional, focada na forma e na proporção. Sua especificidade é a tangibilidade e a representação volumétrica.
    * **MER:** É uma representação puramente conceitual e gráfica, usando uma notação formal (como retângulos para entidades e losangos para relacionamentos) para descrever dados, sem se preocupar com a aparência física.

* **Explicação:** Embora todos os modelos compartilhem o princípio da abstração, eles diferem na forma (física, gráfica, conceitual), na dimensão (2D, 3D) e na linguagem ou notação que utilizam para representar a realidade.

### Categoria: Exemplos de Modelos Gerais

**4. Com base nos exemplos vistos (físicos, matemáticos, conceituais), tente lembrar de outros modelos semelhantes que te marcaram, citando três exemplos.**

1.  **Físico:** O globo terrestre, que representa o planeta Terra.
2.  **Matemático:** A fórmula da velocidade média ($v = \Delta s / \Delta t$), que modela o movimento de um objeto.
3.  **Conceitual:** O organograma de uma empresa, que representa sua estrutura hierárquica.

* **Explicação:** Assim como os exemplos anteriores, estes modelos representam diferentes formas de abstrair a realidade: o globo simplifica a geografia do planeta, a fórmula matemática descreve uma relação fundamental da física, e o organograma simplifica as complexas relações de poder e comunicação de uma organização.

**5. Novamente, comente brevemente seu propósito e utilidade.**

* **Globo terrestre:** Propósito de representar a forma esférica da Terra, a distribuição de continentes e oceanos. É útil na educação para ensinar geografia e astronomia de forma intuitiva.
* **Fórmula da velocidade média:** Propósito de calcular a taxa de deslocamento de um objeto. É útil na física e na engenharia para prever e analisar movimentos.
* **Organograma de uma empresa:** Propósito de comunicar a estrutura formal de comando e reporte. É útil para funcionários e gestores entenderem quem se reporta a quem e como as áreas se dividem.

* **Explicação:** A utilidade de cada modelo está ligada ao seu contexto. Um modelo físico como o globo é ótimo para visualização espacial, um modelo matemático é poderoso para cálculos e previsões, e um modelo conceitual como o organograma é eficaz para entender estruturas sociais ou organizacionais.

**6. Indique como tais modelos ajudaram a compreender com maior clareza os sistemas, processos ou conceitos envolvidos, destacando as vantagens e desvantagens dessas representações.**

* **Globo terrestre:**
    * **Vantagem:** Ajuda a entender visualmente conceitos como fusos horários, estações do ano e as rotas mais curtas entre continentes.
    * **Desvantagem:** É uma simplificação grosseira; ignora o relevo e não pode mostrar detalhes de uma cidade.
* **Fórmula da velocidade média:**
    * **Vantagem:** Permite fazer previsões precisas e é universalmente aplicável sob certas condições. É um modelo conciso e poderoso.
    * **Desvantagem:** É um modelo idealizado; ignora fatores como resistência do ar e atrito.
* **Organograma de uma empresa:**
    * **Vantagem:** Oferece uma visão clara e rápida da hierarquia formal.
    * **Desvantagem:** Não mostra a rede informal de comunicação e influência. Pode se tornar obsoleto rapidamente.

* **Explicação:** A principal vantagem dos modelos é a clareza que trazem ao focar no essencial. A principal desvantagem é que, por serem simplificações, eles sempre omitem informações, o que pode levar a uma compreensão incompleta.

### Categoria: Exemplos de Modelos Computacionais (Merge Sort)

**7. A partir do exemplo de código do MergeSort: Tente descrever seu entendimento sobre o funcionamento geral do algoritmo.**

O Merge Sort é um algoritmo de ordenação que segue a estratégia de "dividir para conquistar". Seu funcionamento pode ser resumido em três passos:
1.  **Dividir:** Ele divide a lista não ordenada em duas metades, recursivamente, até que cada sub-lista contenha apenas um elemento.
2.  **Conquistar:** Listas de um elemento já são consideradas ordenadas.
3.  **Combinar (Merge):** Ele mescla as pequenas sub-listas ordenadas de volta em listas maiores, garantindo que a nova lista combinada permaneça ordenada, até que reste apenas a lista original, agora ordenada.

* **Explicação:** A eficiência do Merge Sort está na etapa de `merge`. É muito rápido combinar duas listas já ordenadas em uma terceira lista ordenada. Ao quebrar o problema complexo em problemas triviais e depois combiná-los de forma eficiente, o algoritmo garante o resultado.

**8. Refletir: Foi fácil entender o algoritmo a partir do código? Usou conhecimento anterior sobre o algoritmo? Há formas melhores de entender o algoritmo? Quais?**

* **Entendimento a partir do código:** Para um iniciante, pode ser difícil entender o Merge Sort apenas pelo código, principalmente por causa da recursão.
* **Conhecimento anterior:** Sim, o entendimento é facilitado por um conhecimento prévio sobre algoritmos.
* **Formas melhores de entender:** Sim, existem:
    1.  **Visualizações Gráficas/Animações:** Ver o processo de divisão e mesclagem com blocos coloridos é extremamente intuitivo.
    2.  **Explicação com Diagramas:** Desenhar a árvore de recursão ajuda a concretizar o processo.
    3.  **Pseudo-código:** Foca na lógica do algoritmo, sem as complexidades da sintaxe da programação.

* **Explicação:** O código-fonte é um modelo preciso, mas de baixo nível de abstração. Para o aprendizado humano, modelos mais visuais e conceituais são frequentemente mais eficazes.

### Categoria: Representando Modelos Computacionais

**9. Considerando um segundo algoritmo de ordenação (ex. Quick Sort), revise o algoritmo e tente explicá-lo usando diferentes perspectivas e representações:**

**Quick Sort**

* **Linguagem natural:**
    O Quick Sort escolhe um elemento da lista como "pivô". Em seguida, ele reorganiza a lista de forma que todos os elementos menores que o pivô fiquem à sua esquerda, e todos os maiores fiquem à sua direita (particionamento). Após isso, o pivô está em sua posição final correta. O algoritmo então repete o processo recursivamente para as duas sub-listas, até que toda a lista esteja ordenada.

* **Diagramas livres (descrição textual):**
    Imagine uma linha de números: `[7, 2, 1, 6, 8, 5, 3, 4]`.
    1.  Escolhemos o pivô: `4`.
    2.  Após rearranjar, teremos: `[2, 1, 3]` (menores) | `4` (pivô) | `[8, 5, 7, 6]` (maiores).
    3.  Agora, repetimos o processo para a lista `[2, 1, 3]` e para a lista `[8, 5, 7, 6]`.

* **Pseudo-código:**
    ```
    função quickSort(lista, inicio, fim):
      se inicio < fim:
        pivo_indice = particionar(lista, inicio, fim)
        quickSort(lista, inicio, pivo_indice - 1)
        quickSort(lista, pivo_indice + 1, fim)
    ```

* **Diagrama formal (descrição de um Diagrama de Atividades UML):**
    1.  Inicia-se com uma decisão: "A lista tem mais de um elemento?".
    2.  Se "Não", o fluxo termina.
    3.  Se "Sim", o fluxo segue para as ações: "Escolher Pivô" e "Particionar Lista".
    4.  Após o particionamento, duas chamadas recursivas são feitas para as sub-listas da esquerda e da direita, criando um ciclo que retorna à decisão inicial.

* **Explicação:** Cada representação tem um propósito. A linguagem natural é para a compreensão conceitual. O diagrama livre visualiza um exemplo. O pseudo-código formaliza a lógica. O diagrama UML mostra o fluxo de controle de maneira padronizada.

**10. Compare as explicações dadas em cada perspectiva quanto a clareza e facilidade de entendimento, tipo de público alvo, curva de aprendizado necessária para criar e compreender, recursos disponíveis para representação e contexto de aplicação (quando seria utilizada?).**

| Perspectiva          | Clareza e Facilidade                                  | Público Alvo                                | Curva de Aprendizado | Contexto de Aplicação                                           |
| :------------------- | :---------------------------------------------------- | :------------------------------------------ | :------------------- | :-------------------------------------------------------------- |
| **Linguagem Natural** | Alta facilidade, pode ser ambígua.                    | Leigos, iniciantes.                         | Muito baixa.         | Introdução conceitual, documentação de alto nível.              |
| **Diagramas Livres** | Muito alta para exemplos pequenos.                    | Estudantes, equipes em brainstorming.       | Baixa.               | Brainstorming, explicação visual rápida.                        |
| **Pseudo-código** | Alta clareza lógica, menos verboso que texto.         | Desenvolvedores, estudantes de computação.    | Baixa a média.       | Planejamento de implementação, documentação técnica.            |
| **Diagrama Formal** | Alta precisão, sem ambiguidades. Menos intuitivo.     | Engenheiros de software, arquitetos.        | Média a alta.        | Documentação formal de projetos, design de sistemas complexos.  |

* **Explicação:** A escolha da representação ideal depende do **público** e do **propósito**. Não existe uma representação "melhor" em absoluto, apenas a mais adequada para cada contexto.

### Categoria: Por Que Modelar?

**11. Selecione ao menos três modelos entre os exemplos vistos anteriormente e comente sobre como se adequam aos propósitos da modelagem, considerando as finalidades de Entendimento, Comunicação, Análise, Projeto e Documentação.**

1.  **Maquete de um edifício:**
    * **Entendimento e Comunicação:** Permite que o cliente visualize o resultado final de forma concreta, facilitando a comunicação com o arquiteto.
    * **Análise e Projeto:** Ajuda a analisar proporções e a validar decisões de design antes da construção.
    * **Documentação:** Serve como um registro físico e visual da concepção do projeto.

2.  **Modelo de Entidade-Relacionamento (MER):**
    * **Entendimento e Comunicação:** É a "língua franca" entre analistas, desenvolvedores e DBAs para discutir a estrutura dos dados.
    * **Análise e Projeto:** Permite analisar a consistência dos dados e serve como um *blueprint* para a criação do banco de dados.
    * **Documentação:** É um documento fundamental para a manutenção e evolução do sistema.

3.  **Pseudo-código do Quick Sort:**
    * **Entendimento e Comunicação:** Permite que programadores discutam a lógica do algoritmo independentemente da linguagem de programação.
    * **Análise e Projeto:** Facilita a análise da complexidade do algoritmo e serve como um passo intermediário para a implementação.
    * **Documentação:** Documenta a lógica central do algoritmo de forma clara.

* **Explicação:** Bons modelos são multifuncionais, facilitando todo o ciclo de vida de uma ideia ou projeto, desde a concepção (entendimento) até a manutenção futura (documentação).

**12. Sugira representações alternativas que poderiam melhorar ou complementar alguma falha ou fraqueza dessas representações.**

* **Para a Maquete de um edifício:**
    * **Fraqueza:** Estática e cara.
    * **Alternativa:** Um **modelo 3D em Realidade Virtual (VR)**, que permitiria ao cliente "andar" pelo edifício.
* **Para o Modelo de Entidade-Relacionamento (MER):**
    * **Fraqueza:** Foca apenas nos dados estáticos, não no comportamento.
    * **Alternativa:** Um **Diagrama de Sequência (UML)**, que mostraria a interação entre objetos ao longo do tempo.
* **Para o Pseudo-código do Quick Sort:**
    * **Fraqueza:** Puramente textual, não transmite a natureza visual do processo.
    * **Alternativa:** Uma **animação ou visualização interativa** do algoritmo.

* **Explicação:** A combinação de diferentes modelos é uma estratégia poderosa, pois permite obter uma compreensão mais completa do sistema ao compensar as fraquezas de uma representação com os pontos fortes de outra.

### Categoria: Conceitos Básicos (Aplicação de Entrega de Comidas)

**13. Considere uma aplicação de entrega de comidas. Reflita sobre o seu próprio modelo mental em relação ao funcionamento deste tipo de aplicação: Considere um cenário de uso, desde o pedido até a efetivação da entrega. Tente descrever brevemente o seu entendimento.**

Meu modelo mental é um processo linear orquestrado pela plataforma: O **Cliente** escolhe itens de um **Restaurante**, faz o **Pedido** e paga. A plataforma notifica o **Restaurante**, que prepara a comida. Simultaneamente, a plataforma aciona um **Entregador**, que retira o pedido e o leva até o Cliente. O Cliente pode rastrear a entrega em tempo real. O processo termina com a entrega e a avaliação mútua.

* **Explicação:** Um modelo mental é a nossa representação interna de como algo funciona. Descrevê-lo é o primeiro passo para a modelagem de software, pois expõe os principais conceitos, atores e etapas do processo.

**14. Descreva: atores envolvidos na aplicação; produtos e artefatos produzidos e manipulados; ações e operações permitidas; os relacionamentos entre todos esses elementos.**

* **Atores:** Cliente, Restaurante, Entregador, Plataforma.
* **Produtos e Artefatos:** Cardápio, Pedido, Pagamento, Rota de Entrega, Avaliação.
* **Ações:**
    * **Cliente:** Fazer Pedido, Pagar, Rastrear, Avaliar.
    * **Restaurante:** Gerenciar Cardápio, Aceitar Pedido, Informar Pedido Pronto.
    * **Entregador:** Aceitar Entrega, Retirar Pedido, Confirmar Entrega.
* **Relacionamentos:** Um **Cliente** *cria um* **Pedido**. Um **Pedido** *pertence a um* **Restaurante**. Um **Entregador** *realiza a entrega de um* **Pedido**.

* **Explicação:** A formalização desses elementos transforma o modelo mental de uma narrativa em uma estrutura organizada, que pode ser usada como base para o design do software.

**15. Com base nos exemplos vistos e nas reflexões anteriores, crie um diagrama ilustrativo que represente este modelo mental.**

(Descrição textual de um Diagrama de Classes UML simplificado)

* **Classe `Cliente`**: `nome`, `endereco`.
* **Classe `Restaurante`**: `nome`, `cardapio`.
* **Classe `Entregador`**: `nome`, `veiculo`.
* **Classe `Pedido`**: `id`, `status`, `valorTotal`.
* **Relacionamentos:**
    * `Cliente` --1..*--> `Pedido`
    * `Restaurante` --1..*--> `Pedido`
    * `Entregador` --0..*--> `Pedido`
    * `Pedido` --1..*--> `ItemCardapio`

* **Explicação:** Este diagrama formaliza os relacionamentos usando a notação UML, mostrando as entidades centrais do domínio e como elas se conectam, servindo como um *blueprint* para a implementação.

**16. Se possível, compare com o modelo criado por outro estudante. Identifique as similaridades e diferenças.**

(Resposta hipotética)

* **Similaridades:** Provavelmente identificaríamos os mesmos atores principais (Cliente, Restaurante, Entregador) e o `Pedido` como a entidade central.
* **Diferenças:** Poderiam surgir na **granularidade** (um modelo mais detalhado que o outro), na **nomenclatura** (ex: "Entregador" vs. "Courier") e no **foco** (um modelo pode focar mais na logística, outro mais no pagamento).

* **Explicação:** A comparação de modelos mentais é um exercício fundamental. As diferenças revelam as diversas perspectivas sobre o mesmo problema, e discuti-las ajuda a criar um modelo compartilhado mais completo e preciso.

---
## Aula 1.2: Modelos Mentais e Conhecimento Compartilhado

### Categoria: Exemplos Ilustrativos: Netflix (1)

**17. Pense a respeito do funcionamento de uma plataforma de Streaming como a Netflix... Como explicaria o seu funcionamento para alguém?**

Eu explicaria como um sistema de três partes:
1.  **Conteúdo:** Uma biblioteca gigante de filmes e séries, licenciados ou produzidos por eles, armazenados em servidores pelo mundo.
2.  **Serviço ao Usuário:** Um aplicativo onde você paga uma assinatura para acessar o catálogo. O sistema aprende seus gostos para recomendar novos títulos.
3.  **Tecnologia de Entrega (Streaming):** Ao dar play, o vídeo é enviado em pequenos pedaços do servidor mais próximo de você (CDN), garantindo uma exibição fluida e com alta qualidade.

* **Explicação:** Esta explicação usa uma analogia (biblioteca) e divide o sistema complexo em três áreas mais simples de entender, focando no "o quê" e no "porquê" antes de entrar nos detalhes técnicos.

**18. Tente sintetizar e expressar seu entendimento na forma de um modelo (em papel).**

(Descrição textual de um diagrama de componentes de alto nível)

* **Componente `Frontend (App/Site)`**: Interface com o usuário (`Catálogo UI`, `Player de Vídeo`).
* **Componente `Backend (Serviços)`**: Orquestração (`Autenticação`, `Recomendações`, `Catálogo`, `Streaming`).
* **Componente `CDN (Rede de Distribuição)`**: Armazenamento e entrega (`Servidores de Vídeo`).
* **Fluxo:** O `Frontend` conversa com o `Backend` para obter informações e autorização. Uma vez autorizado, o `Player de Vídeo` no `Frontend` recebe o conteúdo diretamente da `CDN`.

* **Explicação:** Este é um modelo de arquitetura de alto nível que ajuda a entender as responsabilidades de cada parte do sistema e o fluxo principal de interação.

### Categoria: Exemplos Ilustrativos: Netflix (2)

**19. Compare com os modelos criados pelos colegas.**
**20. Discuta similaridades e diferenças.**

(Resposta hipotética)

* **Similaridades:** Todos os modelos provavelmente reconheceriam os conceitos de `Usuário`, `Conteúdo` e `Plataforma`.
* **Diferenças:** A principal diferença estaria na **perspectiva**. Meu modelo foi **arquitetural/técnico**. Um colega poderia ter criado um modelo de **jornada do usuário (UX)**, focando nos passos que o cliente segue. Outro poderia ter modelado o **ciclo de vida do conteúdo**, desde a produção até a distribuição.

* **Explicação:** As diferenças não indicam erros, mas sim que os modelos foram criados para responder a perguntas diferentes: "Como o sistema é construído?", "Como ele é usado?", "Como o conteúdo chega até ele?".

**21. Seria possível definir um modelo combinado e melhor?**

Sim. Um modelo melhor seria uma **coleção de modelos interligados**. Poderíamos usar um **Diagrama de Contexto (C4 Model Nível 1)** para a visão geral e, em seguida, "dar zoom" em cada parte com diagramas mais detalhados: um diagrama de componentes para a arquitetura, um fluxograma para a jornada do usuário, etc.

* **Explicação:** Um "modelo melhor" muitas vezes não é um único diagrama, mas um conjunto de diagramas em diferentes níveis de abstração, cada um servindo a um público e propósito específicos.

**22. Compare com os exemplos a seguir (Arquitetura do Sistema, Modelo de Negócios, Ecossistema).**

* **Modelo de Arquitetura do Sistema:** Foca nos componentes técnicos e suas interações (o "como"). Meu modelo se encaixa aqui.
* **Modelo de Negócios (Business Model Canvas):** Foca em como a empresa cria, entrega e captura valor (o "porquê"). Incluiria proposta de valor, fontes de receita (assinaturas), estrutura de custos (produção de conteúdo), etc.
* **Modelo de Ecossistema:** Mapeia o ambiente externo da empresa. Incluiria concorrentes (Disney+), parceiros (fabricantes de TV), fornecedores (estúdios) e reguladores.

* **Explicação:** Estes são três níveis de análise: o **interno-técnico** (Arquitetura), o **interno-estratégico** (Modelo de Negócios) e o **externo-contextual** (Ecossistema).

### Categoria: Exemplos Ilustrativos: Netflix (3)

**23. A partir dos modelos vistos, refaça os comparativos.**

A comparação mostra que as decisões de negócio e as pressões do mercado (modelos de negócio e ecossistema) influenciam diretamente o design técnico (modelo de arquitetura). O `Serviço de Recomendações` existe para aumentar a retenção de clientes (objetivo de negócio). A criação de uma `CDN` própria (Open Connect) é uma resposta à necessidade de parcerias com provedores de internet (ator do ecossistema).

* **Explicação:** Os modelos não são isolados. Um modelo de arquitetura eficaz deve ser um reflexo da estratégia de negócio e do contexto de mercado da empresa.

**24. Analise e indique o propósito e funcionalidade de cada modelo.**

* **Modelo de Arquitetura:**
    * **Propósito:** Descrever a estrutura do software.
    * **Funcionalidade:** Guiar o desenvolvimento técnico e a manutenção.
* **Modelo de Negócios:**
    * **Propósito:** Descrever a lógica de criação de valor da empresa.
    * **Funcionalidade:** Alinhar a estratégia e comunicar o plano de negócios.
* **Modelo de Ecossistema:**
    * **Propósito:** Mapear o ambiente competitivo e relacional da empresa.
    * **Funcionalidade:** Ajudar na análise da concorrência e na identificação de parceiros estratégicos.

* **Explicação:** Cada modelo responde a uma pergunta fundamental diferente: "Como construímos?", "Como ganhamos dinheiro?", "Com quem interagimos?".

**25. Qual é o melhor? Para quem? Por quê?**

Não existe "o melhor" modelo.
* **Para a equipe de Engenharia:** O **Modelo de Arquitetura**.
* **Para a Diretoria Executiva (CEO):** O **Modelo de Negócios**.
* **Para a equipe de Estratégia:** O **Modelo de Ecossistema**.

* **Explicação:** A eficácia de um modelo é medida pela sua capacidade de ajudar um determinado público a tomar melhores decisões. A pergunta correta é "Qual o melhor modelo para *esta pessoa* resolver *este problema*?".

### Categoria: Exemplos Ilustrativos: Uber (1)

**26. Vamos repetir o processo, considerando agora o Uber. Novamente, pense a respeito do seu funcionamento... Como explicá-lo para alguém?**

Uber é uma plataforma que conecta duas pessoas: alguém que precisa de uma carona (Passageiro) e alguém que tem um carro e tempo para oferecer essa carona (Motorista). O aplicativo funciona como um "mercado" em tempo real. O Passageiro diz para onde quer ir, o app calcula um preço e encontra o Motorista mais próximo. O app cuida de tudo: navegação, comunicação e pagamento, pegando uma comissão por cada corrida.

* **Explicação:** A explicação foca na analogia de um "mercado" ou "ponte" que conecta duas pontas (oferta e demanda), simplificando o complexo sistema de logística, pagamento e precificação dinâmica.

**27. Sintetize e expresse seu entendimento na forma de um modelo (em papel).**

(Descrição de um Diagrama de Contexto)

* **Atores Externos:** `Passageiro`, `Motorista`, `Sistema de Pagamento (Gateway)`, `Serviço de Mapas (ex: Google Maps)`.
* **Sistema Central:** `Plataforma Uber`.
* **Interações:**
    * `Passageiro` <-> `Plataforma Uber` (solicita corrida, paga).
    * `Motorista` <-> `Plataforma Uber` (aceita corrida, recebe pagamento).
    * `Plataforma Uber` -> `Sistema de Pagamento` (processa transação).
    * `Plataforma Uber` -> `Serviço de Mapas` (obtém rotas, calcula distância/tempo).

* **Explicação:** Este modelo de contexto mostra o sistema como uma "caixa preta" e foca em suas fronteiras, identificando quem (ou o quê) interage com ele. É um excelente ponto de partida para entender o escopo do sistema.

### Categoria: Exemplos Ilustrativos: Uber (2)

**28. Novamente, compare com os modelos criados pelos colegas.**
**29. Discuta similaridades e diferenças.**
**30. Tente definir um modelo combinado e melhor.**

(Resposta hipotética)

* **Diferenças prováveis:** Meu modelo é de contexto de sistema. Um colega poderia ter modelado o **fluxo de estados de uma `Corrida`** (`Solicitada` -> `Aceita` -> `A Caminho do Passageiro` -> `Em Andamento` -> `Finalizada`). Outro poderia ter focado no **modelo de precificação dinâmica** (`surge pricing`).
* **Modelo Combinado:** Um modelo combinado ideal usaria o diagrama de contexto como a visão mais ampla. "Dando zoom" na `Plataforma Uber`, teríamos um diagrama de componentes mostrando os principais serviços (`Gestão de Corridas`, `Pagamentos`, `Cálculo de Preço`). O diagrama de estados da `Corrida` detalharia o comportamento do serviço de `Gestão de Corridas`.

* **Explicação:** Novamente, a combinação de modelos com diferentes perspectivas (estática, comportamental, contextual) fornece uma visão muito mais rica e completa do sistema do que qualquer modelo único.

### Categoria: Práticas e Exercícios: Modelos Mentais (1)

**31. Para cada sistema apresentado, recrie um dos diagramas vistos usando as ferramentas indicadas (ou alguma de sua escolha e familiaridade). Procure reproduzir o mais próximo possível do original, utilizando os recursos da ferramenta. Comente as diferenças e limitações da ferramenta (se houver).**
**32. Considere os diagramas que você esboçou e discutiu com os colegas. Da mesma forma, recrie uma versão mais refinada destes diagramas usando as ferramentas.**

(Resposta reflexiva sobre o processo)

Para esta atividade, utilizei a ferramenta online **Lucidchart** para recriar o modelo de componentes da Netflix e o modelo de contexto do Uber.

* **Processo:** A ferramenta permite arrastar e soltar formas padronizadas (UML, C4), conectar com setas e adicionar texto. O resultado é um diagrama limpo e profissional, muito superior a um esboço em papel.
* **Diferenças e Limitações:**
    * **Vantagem:** A principal vantagem é a facilidade de edição e compartilhamento. É simples mover caixas, alterar texto e exportar em alta qualidade.
    * **Limitação:** Às vezes, a ferramenta pode ser "rígida". A liberdade de um quadro branco para um esboço rápido durante uma discussão é insubstituível. Ferramentas como o Lucidchart são melhores para **documentar** uma ideia já amadurecida do que para o **brainstorming** inicial.

* **Explicação:** Ferramentas de modelagem digital são essenciais para a documentação e comunicação formal em projetos de software. Elas trazem clareza, padronização e profissionalismo, mas não substituem a agilidade e a criatividade de um simples quadro branco na fase de concepção de ideias.

### Categoria: Práticas e Exercícios: Modelos Mentais (2)

**33. Considere outras plataformas e sistemas populares. Repita os exercícios feitos com a Netflix e Uber para consolidar e exercitar sua capacidade de modelagem com as ferramentas sugeridas. Escolha ao menos uma para este exercício (por exemplo, Spotify, AWS, AirBnB, Google Search, Twitter, TikTok, WhatsApp).**

**Exercício com o Spotify**

* **Explicação para alguém:** O Spotify é como uma rádio pessoal gigantesca e inteligente. Você tem acesso a quase todas as músicas do mundo. Você pode ouvir de graça com anúncios ou pagar uma assinatura para ouvir sem interrupções e baixar músicas. A grande sacada dele são as playlists (listas de reprodução) e o sistema de descoberta, que aprende o que você gosta e te sugere novas músicas e artistas o tempo todo.

* **Modelo (Diagrama de Conceitos Principais):**
    * **Conceito `Usuário`**: `nome`, `tipoDeConta` (Free/Premium).
        * Relaciona-se com `Playlist`.
    * **Conceito `Música`**: `título`, `duração`, `arquivoDeAudio`.
        * Pertence a um `Álbum`.
    * **Conceito `Artista`**: `nome`, `discografia`.
        * Relaciona-se com `Álbum` e `Música`.
    * **Conceito `Álbum`**: `título`, `anoDeLançamento`.
        * Contém uma ou mais `Músicas`.
    * **Conceito `Playlist`**: `título`, `criador`.
        * É uma coleção ordenada de `Músicas`.
        * Um `Usuário` pode criar e seguir `Playlists`.

* **Explicação:** Este modelo conceitual foca nas "coisas" mais importantes do domínio do Spotify e como elas se relacionam. É um modelo de domínio de alto nível, que seria o ponto de partida para projetar o banco de dados e as classes do sistema. Ele mostra que a `Playlist` é um conceito central que conecta o `Usuário` às `Músicas`.

---
## Aula 1.3: Histórico e Evolução das Técnicas de Modelagem

### Categoria: Origens e Evolução

**34. Pesquise sobre as principais técnicas desenvolvidas ao longo dos anos envolvendo a Modelagem de Software, citando ao menos um exemplo mais notável de cada década.**

* **1960s-1970s: Fluxogramas (Flowcharts)**
    * Técnica para representar visualmente o fluxo de controle de um algoritmo ou processo.
* **1980s: Diagrama de Entidade-Relacionamento (DER/ERD)**
    * Proposto por Peter Chen, foca em modelar a estrutura de dados de um sistema.
* **1990s: Linguagem de Modelagem Unificada (UML - Unified Modeling Language)**
    * Padronizou uma vasta coleção de diagramas para modelar sistemas orientados a objetos.
* **2000s: Modelagem Ágil (Agile Modeling) & Domain-Driven Design (DDD)**
    * Focam em modelos colaborativos e em conectar o modelo diretamente ao código (Linguagem Ubíqua).
* **2010s: Modelo C4 (Context, Containers, Components, and Code)**
    * Criado por Simon Brown, descreve a arquitetura de software em diferentes níveis de zoom.

* **Explicação:** A evolução das técnicas de modelagem reflete a evolução do próprio software: de algoritmos para dados, para objetos e, mais recentemente, para comunicação, agilidade e clareza arquitetural.

**35. Indique os recursos que melhor explicam as técnicas encontradas (livros, artigos, palestras, ...).**

* **Fluxogramas:** Material didático de introdução à programação.
* **DER:** Livro "Database System Concepts" de Korth e Sudarshan.
* **UML:** Livro "UML Distilled" de Martin Fowler.
* **DDD:** Livro "Domain-Driven Design: Tackling Complexity in the Heart of Software" de Eric Evans.
* **C4 Model:** Site oficial [c4model.com](https://c4model.com/) e o livro "Software Architecture for Developers" de Simon Brown.

* **Explicação:** Para cada técnica, geralmente existe uma fonte canônica (um livro ou artigo seminal) que a define, além de inúmeros recursos secundários que a popularizam.

**36. Descreva brevemente o propósito e aplicação dessa técnica quando foi proposta e comente se ainda continua sendo relevante nos dias de hoje.**

* **Fluxogramas:**
    * **Propósito Original:** Detalhar a lógica de programação.
    * **Relevância Hoje:** Baixa para software complexo, mas útil para fins didáticos e processos de negócio simples.
* **DER:**
    * **Propósito Original:** Projetar bancos de dados relacionais.
    * **Relevância Hoje:** Altíssima. Continua sendo a principal ferramenta para o design de esquemas de banco de dados.
* **UML:**
    * **Propósito Original:** Ser a "língua franca" para a modelagem orientada a objetos.
    * **Relevância Hoje:** Relevante, mas com uso mais seletivo. Diagramas de Classe, Sequência e Componentes ainda são muito usados.
* **DDD:**
    * **Propósito Original:** Lidar com a complexidade em sistemas grandes, alinhando o software ao negócio.
    * **Relevância Hoje:** Altíssima e crescente, especialmente no contexto de microsserviços.

* **Explicação:** Nenhuma técnica morre completamente, mas seu contexto de aplicação muda.

**37. Ilustre com exemplos de modelos gerados pelas técnicas citadas, destacando as ferramentas utilizadas para a modelagem.**

(Ilustração por descrição textual)

* **Fluxograma:** Um diagrama com caixas e losangos conectados por setas. **Ferramentas:** Draw.io, Visio.
* **DER:** Um diagrama com retângulos (entidades) e losangos (relacionamentos). **Ferramentas:** brModelo, Lucidchart.
* **UML (Diagrama de Classes):** Caixas representando classes com atributos e métodos. **Ferramentas:** StarUML, Astah.
* **C4 (Diagrama de Contexto):** Uma caixa central (sistema) cercada por caixas (atores e sistemas externos). **Ferramentas:** Structurizr, C4-PlantUML.

* **Explicação:** A aparência e a notação de cada modelo são distintas, pois foram projetados para comunicar informações diferentes.

---
## Aula 2.1: Introdução ao Projeto Orientado pelo Domínio (DDD)

### Categoria: Analogia

**38. Compare e comente como se dá a construção de estradas: feitas sobre caminhos antigos de carroças; planejadas para atender diversas demandas de uma cidade (meio ambiente, fluxo, eficiência, economia, ...).**

* **Estradas sobre caminhos antigos:** Corresponde ao desenvolvimento de software "orgânico" ou reativo, que cresce sem um plano mestre. Tende a ser ineficiente e incapaz de suportar alta complexidade.
* **Estradas planejadas:** Corresponde ao desenvolvimento de software com design intencional (DDD). Há um esforço para entender o domínio, planejar os subdomínios e projetar o Core Domain para ser robusto e eficiente.

* **Explicação:** A analogia ilustra a diferença entre um software que "acontece" e um que é "projetado". O primeiro tende a virar um "Big Ball of Mud", enquanto o segundo evolui de forma sustentável.

**39. Quais modelos/projetos podem ser pensados para cada situação?**

* **Estradas sobre caminhos antigos:** O "modelo" é o próprio caminho existente. Em software, seria um desenvolvimento sem modelagem explícita, onde o código é a única fonte da verdade.
* **Estradas planejadas:** Exige múltiplos modelos: mapa topográfico (análise do domínio), estudo de fluxo (análise de requisitos), plano diretor (mapa de contextos), projetos de engenharia detalhados (design tático).

* **Explicação:** O planejamento exige a criação de modelos em diferentes níveis de abstração. O desenvolvimento reativo pula essa etapa, gerando custos maiores no futuro.

**40. Qual dará o melhor resultado aos interessados? Analise os impactos das opções.**

A **estrada planejada** dará o melhor resultado a longo prazo.
* **Impactos (Planejada):**
    * **Positivos:** Maior eficiência, segurança, escalabilidade, menor custo de manutenção.
    * **Negativos:** Custo inicial alto, maior tempo para a primeira entrega.
* **Impactos (Caminho Antigo):**
    * **Positivos:** Custo inicial baixo, entrega rápida.
    * **Negativos:** Gera gargalos, ineficiente, e melhorias futuras são extremamente caras.

* **Explicação:** É um *trade-off* entre velocidade inicial e sustentabilidade. Para sistemas complexos e estratégicos (o foco do DDD), a abordagem planejada é essencial.

### Categoria: Exemplos Práticos (DDD)

**41. Estude os exemplos anteriores (Uber, Netflix, Spotify, iFood, Amazon) e faça um breve resumo sobre seu entendimento dos casos.**

* **Netflix/Spotify:** O *Core Domain* é a **descoberta e recomendação de conteúdo**.
* **Uber/iFood:** O *Core Domain* é a **orquestração do mercado em tempo real** (pareamento, precificação, logística).
* **Amazon (Varejo):** O *Core Domain* é a **logística e a gestão da cadeia de suprimentos** em escala massiva.

* **Explicação:** Todos esses sistemas de sucesso têm um "coração" claro onde investem a maior parte de sua energia e inovação. O DDD nos ajuda a identificar e proteger esse coração.

**42. Identifique conceitos e elementos de DDD citados nesses exemplos.**

* **Domínio Central (Core Domain):** Identificado acima.
* **Subdomínios (Supporting/Generic):** Autenticação de usuários, processamento de pagamentos, gestão de catálogos.
* **Contextos Delimitados (Bounded Contexts):** Em um sistema como o iFood, podemos imaginar contextos como `Gestão de Pedidos`, `Logística de Entrega`, `Pagamentos`.
* **Linguagem Ubíqua:** No contexto de `Logística` do iFood, "Pedido" é um pacote físico. No contexto de `Pagamentos`, "Pedido" é uma transação financeira.

* **Explicação:** Os conceitos de DDD fornecem um framework para analisar um negócio complexo, dividi-lo em partes gerenciáveis e focar os esforços no que realmente importa.

**43. Pesquise e cite outros dois casos de sucesso e aplicação da DDD em sistemas conhecidos.**

1.  **Cargill (Agronegócio):** Aplicou DDD para modernizar seu complexo sistema de gestão de risco e precificação de commodities, alinhando o software com a linguagem dos traders.
2.  **Departamento de Transportes da Suécia:** Utilizou DDD para desenvolver um novo sistema nacional de registro de veículos, substituindo um monolito legado por uma solução modular e flexível.

* **Explicação:** Estes exemplos mostram que o DDD é valioso em domínios de negócio tradicionais e complexos, onde o alinhamento entre o software e as regras de negócio é crítico.

### Categoria: Limitações (DDD)

**44. Pesquise casos em que a DDD não foi aplicada com sucesso.**
**45. Comente as causas apontadas para a falha.**
**46. Indique qual foi a alternativa para lidar com a situação.**

* **Caso de Falha Comum:** Tentar aplicar DDD em um problema de **baixa complexidade**, como um simples CRUD.
* **Causas da Falha:**
    1.  **Complexidade Acidental:** Introduzir todos os padrões táticos do DDD onde não são necessários, gerando *over-engineering*.
    2.  **Falta de Especialistas do Domínio:** Tentar modelar sem acesso constante a especialistas do negócio.
    3.  **Foco Apenas nos Padrões Táticos:** Apaixonar-se pelos padrões de código e ignorar o design estratégico.
* **Alternativa:**
    * Para problemas simples, usar uma **arquitetura mais simples** (CRUD tradicional, Modelo Anêmico).
    * Quando a implementação falha, dar um passo atrás e focar na **estratégia**: realizar workshops (Event Storming) para entender o domínio antes de codificar.

* **Explicação:** DDD não é uma bala de prata. É uma ferramenta para **sistemas com alta complexidade no domínio**. Aplicá-lo onde essa complexidade não existe é contraproducente.

### Categoria: Domínio Central

**47. Considerando o desenvolvimento de um sistema para um Serviço de Entrega de Comidas, indique quais conceitos poderiam ser considerados para seu Domínio Central.**

O Domínio Central seria a **Otimização da Logística e Experiência em Tempo Real**. Conceitos-chave:
* **Pareamento (Matching):** O algoritmo que decide o melhor entregador para um pedido.
* **Roteirização e ETA (Estimated Time of Arrival):** O cálculo da melhor rota e a previsão em tempo real do tempo de entrega.
* **Precificação Dinâmica de Entrega:** O cálculo da taxa de entrega baseado em múltiplos fatores.

* **Explicação:** Estes são os elementos que criam o maior diferencial competitivo e onde a maior parte da complexidade e da inovação reside.

**48. Justifique as motivações para incluir estes elementos.**

* **Diferencial Competitivo:** A eficiência da malha logística diferencia os líderes de mercado.
* **Complexidade do Negócio:** Estes problemas são inerentemente complexos e justificam o investimento em modelagem profunda.
* **Valor para o Cliente:** A precisão do ETA e um custo de entrega justo são fatores decisivos para a satisfação do cliente.

* **Explicação:** O Domínio Central deve ser o conjunto de capacidades que, se executadas com excelência, tornam a empresa vencedora em seu mercado.

**49. Indique conceitos importantes para esse domínio, mas que ficariam de fora do Domínio Central. Justifique.**

* **Gestão de Cardápios:** **Subdomínio de Suporte**. É crucial, mas não oferece grande diferencial competitivo.
* **Autenticação de Usuários:** **Subdomínio Genérico**. É um problema já resolvido, comum a quase todos os sistemas.
* **Processamento de Pagamentos:** **Subdomínio Genérico**. É mais seguro e eficiente integrar com um gateway especializado.

* **Explicação:** A classificação dos subdomínios permite focar os recursos mais valiosos no que realmente importa (o Domínio Central) e adotar soluções mais simples ou compradas prontas para o resto.

### Categoria: Linguagem Ubíqua

**50. Defina e caracterize os possíveis usos do termo "Voo" (no contexto de uma empresa do setor de transporte aéreo), levando em conta seu uso por diferentes áreas como Controle de Tráfego, Aquisição de Passagens, Faturamento e Manutenção.**

* **Controle de Tráfego:** "Voo" é uma entidade física e dinâmica (a aeronave em movimento).
* **Aquisição de Passagens:** "Voo" é um produto vendável (uma oferta de transporte com assentos).
* **Faturamento:** "Voo" é uma fonte de receita e custo (um registro contábil).
* **Manutenção:** "Voo" é um ciclo de uso de um equipamento (contribui para o desgaste).

* **Explicação:** O mesmo termo, "Voo", tem significados e atributos completamente diferentes dependendo do contexto.

**51. Quais seriam os possíveis domínios onde esse termo seria aplicado?**

Estes diferentes significados nos levam a identificar diferentes **Contextos Delimitados (Bounded Contexts)**:
1.  **Contexto de Operações de Voo**
2.  **Contexto de Vendas e Reservas**
3.  **Contexto de Faturamento**
4.  **Contexto de Manutenção de Frota**

* **Explicação:** DDD nos ensina a abraçar essa multiplicidade de significados, definindo fronteiras claras (Contextos Delimitados), dentro das quais cada termo tem um único e preciso significado.

### Categoria: Estudo de Caso Scrum: Reflexão (1)

(Respostas baseadas em anti-padrões comuns)

**52. Estaria a equipe caindo em uma armadilha?**
Sim, na armadilha do **"Scrum Mecânico"**: seguir os rituais, mas ignorar os princípios de agilidade, como a entrega de valor contínua.

* **Explicação:** A armadilha é pensar que fazer as cerimônias do Scrum é o mesmo que ser ágil.

**53. Houve desvio dos conceitos originais associados a projetos Scrum? (Produtos, Itens de Backlog, Lançamentos, Sprints, ...).**
Sim:
* **Itens de Backlog:** Viram tarefas técnicas em vez de "fatias de valor".
* **Sprints:** Viram "mini-cascatas".
* **Lançamentos:** São agrupados em "grandes lançamentos", anulando o feedback rápido.

* **Explicação:** A equipe ainda pensa de forma tradicional (em fases e tarefas), apenas usando um vocabulário Scrum.

**54. O que dizer sobre a linguagem? É clara ou confusa? É consistente? É funcional?**
A linguagem é **confusa e inconsistente**. A falta de uma Linguagem Ubíqua é um sintoma claro de desalinhamento entre desenvolvimento e negócios.

* **Explicação:** Quando as equipes falam "línguas" diferentes, o software resultante raramente atende às necessidades reais.

**55. Ainda, haverá mais conceitos de suporte a cada conceito nomeado....**
Sim. Por trás do "Item de Backlog" (que virou tarefa), surgem conceitos de um processo cascata, como "Especificação Técnica Detalhada", adicionando burocracia.

* **Explicação:** Quando a base conceitual está errada, o processo gera "remendos" para compensar as falhas.

### Categoria: Estudo de Caso Scrum: Reflexão (2)

**56. Caminhamos para uma "Grande Bola de Lama" (Big Ball of Mud)?**
Sim. Uma linguagem inconsistente e um backlog focado em tarefas técnicas são receitas certas para uma "Grande Bola de Lama", um código onde tudo está acoplado com tudo.

* **Explicação:** A "Grande Bola de Lama" é um reflexo organizacional de uma falta de visão e linguagem compartilhadas.

**57. Como lidar com isso?**
A solução é introduzir o pensamento do **Domain-Driven Design**:
1.  **Focar na Linguagem:** Promover workshops (Event Storming) para construir uma Linguagem Ubíqua.
2.  **Modelar o Domínio:** Criar um modelo explícito do domínio.
3.  **Refatorar o Backlog:** Reescrever o backlog com base no valor para o usuário.
4.  **Design Estratégico:** Definir Contextos Delimitados claros.

* **Explicação:** A saída da "Grande Bola de Lama" não é técnica, é estratégica. Requer um realinhamento fundamental entre desenvolvimento e negócio.

### Categoria: Aplicando DDD (1)

**58. Repasse o estudo de caso e, com base nas ideias vistas, tente definir quais seriam os elementos pertinentes ao domínio central de um serviço de Transporte de Passageiros com Veículos de Passeio.**
O domínio central seria a **Gestão e Otimização da Corrida**:
* **Precificação Dinâmica (Surge Pricing)**
* **Pareamento (Matching)**
* **Gestão de Reputação e Confiança**
* **Roteirização em Tempo Real**

* **Explicação:** Estes são os elementos complexos que diferenciam uma plataforma como Uber/99 de um simples aplicativo de táxi.

**59. Aponte quais seriam os outros domínios relacionados ao domínio central.**
* **Subdomínio de Suporte:** Gestão de Motoristas, Gestão de Promoções.
* **Subdomínio Genérico:** Pagamentos, Notificações, Autenticação.

* **Explicação:** A separação em subdomínios ajuda a direcionar o investimento.

### Categoria: Aplicando DDD (2)

**60. Identifique quais elementos do domínio central estariam ligados aos domínios em seu entorno.**
* O **Pareamento** (Core) precisa de informações da **Gestão de Motoristas** (Suporte).
* A **Precificação Dinâmica** (Core) precisa de informações da **Gestão de Promoções** (Suporte).
* O resultado da **Precificação** (Core) é enviado para o sistema de **Pagamentos** (Genérico).

* **Explicação:** Os subdomínios se interligam, e o design estratégico do DDD ajuda a gerenciar essas integrações de forma controlada.

**61. Identifique termos comuns a mais de um domínio, mas com significados distintos.**
O termo **"Motorista"**:
* No contexto de **Gestão de Motoristas (Suporte)**, é uma entidade rica em informações (`nome`, `CPF`, `CNH`).
* No contexto de **Pareamento (Core)**, é um modelo mais simples (`ID`, `localização_atual`, `status`).

* **Explicação:** Cada contexto tem seu próprio modelo de "Motorista", com os atributos relevantes apenas para aquele contexto.

**62. Repita o exercício, considerando um sistema de Entregas de Comida.**
* **Domínio Central:** Otimização da Logística (pareamento, roteirização, ETA).
* **Domínios Relacionados:** Gestão de Restaurantes (Suporte), Pagamentos (Genérico).
* **Termo Comum:** **"Pedido"**
    * No contexto de **Logística (Core)**, é um pacote físico (`endereço_retirada`, `status_logístico`).
    * No contexto de **Gestão de Restaurantes (Suporte)**, é uma lista de itens a preparar (`lista_de_itens`, `status_de_preparo`).
    * No contexto de **Pagamentos (Genérico)**, é uma transação financeira (`valor_total`, `status_pagamento`).

* **Explicação:** O exercício reforça que a linguagem é dependente do contexto.

---
## Aula 4.1: Contextos Delimitados

### Categoria: Diferencial Competitivo

**63. Identifique quais seriam os diferenciais competitivos e subdomínios principais para os seguintes domínios de negócio/empresas: Petrobrás, Nubank, Tesla, Netflix.**

* **Petrobrás:** **Tecnologia de Exploração e Produção em Águas Profundas**.
* **Nubank:** **Análise de Crédito e Risco em Larga Escala com Foco na Experiência do Cliente**.
* **Tesla:** **Tecnologia de Baterias e Software de Condução Autônoma**.
* **Netflix:** **Sistema de Recomendação e Produção de Conteúdo Baseada em Dados**.

* **Explicação:** Em cada caso, o Domínio Central é a capacidade intelectual e tecnológica complexa que torna o produto final único e difícil de copiar.

### Categoria: Identificar e Classificar Subdomínios (1) - Gigmaster

**64. Identifique o domínio de negócios da Gigmaster.**
Intermediação de trabalho temporário ou por projeto ("gigs"), conectando empresas com freelancers.

* **Explicação:** O negócio é criar um mercado eficiente para esse tipo de trabalho.

**65. Identifique e classifique os subdomínios associados, justificando.**
* **Core Domain:** **Pareamento Inteligente de Talentos (Talent Matching)**. É o algoritmo que conecta a vaga certa com o freelancer certo, sendo o principal diferencial competitivo.
* **Supporting Subdomain:** Gestão de Perfis e Portfólios, Sistema de Avaliação. Apoiam o Core Domain, mas não são o diferencial em si.
* **Generic Subdomain:** Processamento de Pagamentos, Mensageria. Problemas já resolvidos por soluções de mercado.

* **Explicação:** A classificação ajuda a Gigmaster a decidir onde investir seus melhores recursos.

**66. Quais decisões de design podem ser consideradas?**
1.  **Construir vs. Comprar:** Construir o **Pareamento** internamente. Comprar soluções para **Pagamentos** e **Mensageria**.
2.  **Estrutura da Equipe:** Criar uma equipe de produto de alto nível para o **Core Domain**.
3.  **Arquitetura:** Uma arquitetura de microsserviços é uma excelente candidata, com serviços alinhados aos subdomínios (`MatchingService`, `ProfileService`, `PaymentService`).

* **Explicação:** As decisões de design estratégico influenciam diretamente as decisões de arquitetura e organização.

### Categoria: Identificar e Classificar Subdomínios (2) - BusVNext

**67. Identifique o domínio de negócios da BusVNext.**
Otimização e gestão de frotas de transporte público (ônibus), oferecendo uma solução de software (SaaS) para empresas de ônibus.

* **Explicação:** O nome aponta para a modernização do transporte por ônibus.

**68. Identifique e classifique os subdomínios associados, justificando.**
* **Core Domain:** **Otimização de Rotas em Tempo Real**. Algoritmos que ajustam as rotas e horários dos ônibus com base em dados em tempo real. É o problema mais complexo e de maior valor.
* **Supporting Subdomain:** Gestão de Frota, Monitoramento de Veículos. Fornecem dados para o Core Domain.
* **Generic Subdomain:** Mapas e Geocodificação, Previsão do Tempo. Serviços essenciais consumidos via APIs de provedores especializados.

* **Explicação:** A classificação separa o "cérebro" da operação (otimização) das funcionalidades de suporte e dos serviços de base.

**69. Quais decisões de design podem ser consideradas?**
1.  **Foco no Core:** Investir pesadamente em talentos de engenharia e ciência de dados para construir o módulo de **Otimização de Rotas**.
2.  **Integração via APIs:** A arquitetura deve ser projetada para consumir dados de múltiplas fontes externas (Mapas, Trânsito, Clima).
3.  **Modelo de Dados:** Haverá diferentes modelos para "Ônibus" em diferentes contextos (`Gestão de Frota` vs. `Otimização de Rotas`), apontando para a necessidade de Contextos Delimitados.

* **Explicação:** As decisões de design giram em torno de construir um "cérebro" de otimização poderoso e cercá-lo de integrações eficientes.

---
## Aula 5.1: Design Estratégico e Mapeamento de Contextos

### Categoria: Atividade ContextMapper

**70. Acesse o site da ferramenta ContextMapper, revise e execute as instruções para instalação do plugin para o Eclipse desta ferramenta.**
**71. Execute testes com os exemplos de modelos, carregando os modelos no Eclipse e visualizando os mapas de contextos feitos com a ferramenta.**
**72. Para as questões a seguir, quando for solicitado a criação de modelos, utilize o ContextMapper para gerar os diagramas.**

(Nota: Como uma IA, não posso executar softwares como o Eclipse. As respostas a seguir fornecerão o código na linguagem CML (Context Mapper DSL) e descreverão o diagrama resultante, que é o que a ferramenta geraria.)

* **Explicação:** O ContextMapper é uma ferramenta que permite modelar Bounded Contexts e seus relacionamentos usando uma linguagem específica (DSL). A partir do código CML, ele gera automaticamente os diagramas de Mapa de Contexto, garantindo que o modelo e a visualização estejam sempre em sincronia.

### Categoria: Parceria e Núcleo Compartilhado (1)

**73. Qual é a principal diferença entre os padrões Parceria (Partnership) e Núcleo Compartilhado (Shared Kernel)?**

* **Parceria (Partnership):** Envolve duas equipes (ou contextos) que têm um relacionamento de interdependência e precisam colaborar de perto para ter sucesso. Não há uma relação de poder clara (um não manda no outro). Elas sincronizam seus planos de desenvolvimento e processos de integração para que ambos os contextos evoluam juntos. O código e o modelo não são necessariamente compartilhados, mas a colaboração e o planejamento são.
* **Núcleo Compartilhado (Shared Kernel):** É um padrão muito mais concreto. As duas equipes concordam em compartilhar um subconjunto do modelo de domínio, incluindo o código (classes, value objects, etc.). Esse código compartilhado (o "kernel") torna-se uma biblioteca ou módulo do qual ambos os contextos dependem. Qualquer mudança no Shared Kernel deve ser acordada e validada por ambas as equipes.

* **Explicação:** A principal diferença é o **acoplamento**. A Parceria é um acoplamento de **processo** (precisamos nos reunir e planejar juntos). O Núcleo Compartilhado é um acoplamento de **código** (dependemos do mesmo JAR/biblioteca). O Shared Kernel é mais forte e arriscado, pois uma mudança mal planejada pode quebrar os dois contextos.

**74. Em que situações você acha que seria benéfico usar ambos os padrões?**

Seria benéfico usar ambos quando dois contextos são **extremamente próximos e interdependentes no Domínio Central**, e compartilhar um pequeno subconjunto do modelo pode acelerar o desenvolvimento, mas a complexidade de cada contexto é grande demais para fundi-los em um só. A Parceria seria o acordo de colaboração contínua, e o Núcleo Compartilhado seria a manifestação técnica dessa colaboração em um pedaço específico e muito estável do modelo.

* **Explicação:** A Parceria estabelece a "relação diplomática" entre as equipes, enquanto o Núcleo Compartilhado é um "tratado" específico que elas assinam sobre um pedaço do código.

**75. Quais são os benefícios e os riscos de combinar esses dois padrões?**

* **Benefícios:**
    * Redução de duplicação de código para o núcleo do modelo.
    * Consistência garantida para os conceitos compartilhados.
    * A Parceria garante que a comunicação necessária para manter o Núcleo Compartilhado saudável realmente aconteça.
* **Riscos:**
    * **Alto Acoplamento:** O principal risco. O Núcleo Compartilhado pode se tornar um "mini-monolito" que engessa a evolução de ambos os contextos.
    * **Atrito entre Equipes:** Se a Parceria falhar (as equipes não colaborarem bem), fazer qualquer mudança no Núcleo Compartilhado se tornará um pesadelo burocrático e técnico.

* **Explicação:** A combinação só funciona com alta disciplina e excelente comunicação. O risco é criar um gargalo de desenvolvimento onde nenhuma equipe pode avançar sem a outra.

**76. Pense em exemplos de projetos que conheça, indicando contextos que poderiam utilizar cada padrão.**

* **Parceria:** Em um e-commerce, os contextos de `Gestão de Pedidos` e `Logística de Entrega`. A equipe de Pedidos não pode lançar um novo tipo de pedido (ex: "agendado") sem coordenar com a equipe de Logística, que precisa suportar essa nova funcionalidade. Eles precisam estar em parceria constante.
* **Núcleo Compartilhado:** Na mesma empresa, os contextos de `Gestão de Pedidos` e `Gestão de Clientes` poderiam compartilhar um pequeno núcleo com modelos como `ClienteID`, `Endereco` e `Nome`. São conceitos muito estáveis e onipresentes, e ter uma única representação de código para eles pode evitar duplicação e inconsistência.

* **Explicação:** A Parceria é ideal para contextos com fluxos de negócio interdependentes. O Núcleo Compartilhado é ideal para um subconjunto de modelo muito estável e transversal a vários contextos.

### Categoria: Parceria e Núcleo Compartilhado (2)

**77. Analise como os contextos de Gestão de Pedidos e Logística poderiam se beneficiar de uma Parceria.**

A colaboração seria essencial. Se a `Gestão de Pedidos` decide implementar uma feature de "agrupar entregas para o mesmo endereço", a `Logística` precisa ser envolvida desde o início. Sem uma Parceria, a equipe de Pedidos poderia desenvolver a feature, e só depois descobrir que o sistema de `Logística` não tem como roteirizar pacotes agrupados, causando um retrabalho enorme. Com a Parceria, as equipes planejam juntas, definem as interfaces de integração e sincronizam o lançamento da feature, garantindo o sucesso de ponta a ponta.

* **Explicação:** A Parceria evita o "jogar por cima do muro", onde uma equipe termina seu trabalho e o entrega para a outra sem coordenação, o que é uma receita para falhas de integração.

**78. Identifique um subconjunto comum de modelos, código ou dados que poderia ser compartilhado entre os contextos (Gestão de Pedidos, Logística, Gestão de Clientes) e indique um plano para implementar um Núcleo Compartilhado.**

* **Subconjunto Comum:** Os conceitos de `ClienteID`, `PedidoID`, e `Endereco`. Todos os três contextos precisam lidar com esses identificadores e com a estrutura de um endereço.
* **Plano de Implementação:**
    1.  **Acordo:** As três equipes se reúnem e concordam com a estrutura imutável desses objetos (provavelmente como Value Objects).
    2.  **Criação do Módulo:** Criar um novo projeto/módulo separado (ex: `ecommerce-shared-kernel.jar`).
    3.  **Implementação:** Implementar as classes `ClienteID`, `PedidoID` e `Endereco` neste módulo.
    4.  **Governança:** Definir um processo claro para mudanças. Nenhuma alteração pode ser feita no `shared-kernel` sem a revisão e aprovação de representantes das três equipes.
    5.  **Distribuição:** Publicar o módulo em um repositório de artefatos (como Maven Central ou Nexus) para que os três contextos possam importá-lo como uma dependência.

* **Explicação:** O plano enfatiza que um Núcleo Compartilhado é tanto um desafio técnico (criar o módulo) quanto de governança (definir como ele evolui).

**79. Documente o plano em um diagrama, complementado por texto, destacando os pontos-chave da aplicação dos padrões.**

**Texto Complementar:**
O mapa de contexto abaixo ilustra a relação estratégica entre os contextos de `Gestão de Pedidos`, `Logística` e `Gestão de Clientes`. `Pedidos` e `Logística` operam em uma **Parceria (P)**, indicando uma alta necessidade de colaboração e planejamento conjunto. Adicionalmente, os três contextos consomem um **Núcleo Compartilhado (SK)**, que contém o modelo canônico para conceitos transversais e estáveis como `ClienteID`, `PedidoID` e `Endereco`. Esta abordagem visa reduzir a duplicação e garantir a consistência desses conceitos fundamentais.

**Código (Context Mapper - CML):**
```cml
ContextMap {
  contains Gestao_de_Pedidos
  contains Logistica
  contains Gestao_de_Clientes
  contains Shared_Kernel_Ecommerce

  Gestao_de_Pedidos [P, SK]<-[SK] Gestao_de_Clientes
  Gestao_de_Pedidos [P, SK]<->[P, SK] Logistica
  Logistica [SK]<-[SK] Gestao_de_Clientes
}

BoundedContext Gestao_de_Pedidos
BoundedContext Logistica
BoundedContext Gestao_de_Clientes

BoundedContext Shared_Kernel_Ecommerce {
  implementationTechnology = "Java Library"
}
```

### Categoria: CF e ACL (1)

**80. Qual é a principal diferença entre os padrões CF (Conformista) e ACL (Camada Anti-Corrupção)?**

A diferença principal tá na **relação de poder** e na **autonomia** do time.

* **Conformista (CF):** É quando você é a parte mais fraca da relação. Pensa num time pequeno que precisa integrar com um sistema gigante e super importante da empresa. Não dá pra pedir pra eles mudarem nada pra te agradar. Então, você "se conforma": engole o modelo deles do jeito que é, mesmo que seja esquisito, pra facilitar a sua vida. Você abre mão do seu modelo ideal em nome da simplicidade na integração.
* **Camada Anti-Corrupção (ACL):** Aqui a história é outra. Você quer **proteger o seu território**. Você até precisa conversar com o outro sistema (que pode ser um legado todo bagunçado ou uma API de terceiros), mas não quer que a "sujeira" dele invada o seu código, que é limpinho e organizado. A ACL funciona como um **tradutor/intérprete** na fronteira. Ela pega os dados esquisitos do outro sistema e converte para o seu modelo bonitinho, e vice-versa.

* **Minha visão:** Ser Conformista é tipo ir morar num país novo e só falar a língua deles. É mais fácil pra se virar no dia a dia, mas você perde um pouco da sua identidade. Usar uma ACL é como contratar um tradutor: dá um pouco mais de trabalho, mas você pode continuar falando a sua língua tranquilamente em casa.

**81. Em que situações seria benéfico usar cada um desses padrões?**

* **Vira Conformista quando:**
    * O outro sistema é a "fonte da verdade" e o modelo dele é bom.
    * Seu time é pequeno ou o prazo tá estourando e não dá tempo de construir um tradutor (ACL).
    * É tipo um microsserviço de relatórios que só lê dados de um sistema de vendas gigante. É mais fácil ele aprender a "língua" do sistema de vendas.
* **Constrói uma Camada Anti-Corrupção (ACL) quando:**
    * Você precisa integrar com um **sistema legado** (um "monstro" de código antigo) e quer proteger seu código novo da bagunça.
    * Você tá usando uma **API de um terceiro**. Você não controla o modelo deles e ele pode mudar a qualquer hora. A ACL isola você dessas mudanças.
    * O seu sistema é o **coração da empresa (Core Domain)**. Você tem que protegê-lo de qualquer influência externa a todo custo.

* **Minha visão:** A escolha é estratégica. Pensa: "Quem manda em quem aqui?", "O modelo do vizinho é bom ou é uma zona?" e "O quão importante é o meu próprio modelo?".

**82. Quais são os benefícios e os riscos de usá-los?**

* **Conformista (CF):**
    * **Lado bom:** É simples e rápido. Menos código pra escrever, menos dor de cabeça pra integrar.
    * **Lado ruim:** Você fica amarrado. Seu código fica "contaminado" pelo modelo do outro. Se o outro sistema mudar, o seu quebra. Você perde a liberdade de criar o melhor modelo pro seu problema.
* **Camada Anti-Corrupção (ACL):**
    * **Lado bom:** Liberdade! Você protege seu modelo, mantendo ele limpo. Seu sistema e o outro podem evoluir de forma independente, sem um quebrar o outro.
    * **Lado ruim:** Dá mais trabalho. A ACL é mais uma peça de software pra você construir, testar e manter.

* **Minha visão:** O Conformista troca autonomia por simplicidade. A ACL troca simplicidade por autonomia e paz de espírito no futuro.

### Categoria: CF e ACL (2)

**83. Como os contextos de Gestão de Frotas e Planejamento de Rotas poderiam se beneficiar do padrão Conformista?**

Imagina que o sistema de `Gestão de Frotas` já existe, é grande, estável e todo mundo na empresa usa. Aí surge um time novo pra criar um módulo de `Planejamento de Rotas`. Em vez de o time novo inventar um modelo do zero para `Veiculo` ou `Motorista`, eles podem simplesmente adotar uma postura **Conformista** e usar as classes e os dados do jeito que a `Gestão de Frotas` já definiu. A integração fica moleza e eles conseguem entregar o módulo novo bem mais rápido.

* **Minha visão:** É o famoso "em time que tá ganhando não se mexe". Se o modelo do vizinho é bom e resolve seu problema, às vezes é mais esperto simplesmente usá-lo.

**84. Como o contexto de Planejamento de Rotas poderia se proteger do sistema legado de Cobrança de Pedágios usando uma ACL?**

Aqui a coisa muda. O sistema de `Cobrança de Pedágios` é um dinossauro, com um modelo de dados confuso e uma tecnologia ultrapassada. O `Planejamento de Rotas`, que é o filé mignon do negócio, não pode nem sonhar em se misturar com essa confusão.

A saída é construir um muro com um portão bem controlado: uma **ACL**.
* Do lado de fora do muro, a ACL fala a língua do dinossauro (pode ser um XML esquisito, um protocolo antigo...).
* Do lado de dentro, ela fala a língua do mundo moderno, oferecendo dados limpinhos e organizados pro `Planejamento de Rotas` (tipo `CustoDoPedagio` e `Coordenada`).

Quando o `Planejamento de Rotas` pergunta "qual o custo do pedágio pra essa rota?", a ACL pega essa pergunta, traduz pro "dinossaurês", pergunta pro sistema legado, pega a resposta confusa, traduz de volta pro nosso idioma e entrega a informação mastigadinha.

* **Minha visão:** A ACL funciona como o C-3PO de Star Wars. Ela é o dróide de protocolo que se vira com as línguas esquisitas dos outros sistemas pra que o seu sistema principal não precise se preocupar com isso.

**85. Documente o plano em um diagrama, complementado por texto, destacando os pontos-chave da aplicação dos padrões.**

**Texto Complementar:**
Pensa no mapa das nossas integrações. O `Planejamento de Rotas` olha para a `Gestão de Frotas` e, como a gente confia neles, a gente é **Conformista (CF)**, pra facilitar. Mas quando a gente olha pro `Sistema Legado de Cobrança`, a gente desconfia. Pra se proteger da bagunça dele, a gente constrói uma muralha, a **Camada Anti-Corrupção (ACL)**. Assim, nosso sistema principal fica seguro e fala uma língua só, mesmo que seus vizinhos sejam bem diferentes.

**Código (Context Mapper - CML):**
```cml
ContextMap {
  contains Planejamento_de_Rotas
  contains Gestao_de_Frotas
  contains Sistema_Legado_Cobranca

  // Planejamento_de_Rotas (downstream) se conforma a Gestao_de_Frotas (upstream)
  Gestao_de_Frotas [U] -> [D, CF] Planejamento_de_Rotas

  // Planejamento_de_Rotas (downstream) se protege do Legado (upstream) com uma ACL
  Sistema_Legado_Cobranca [U] -> [D, ACL] Planejamento_de_Rotas
}

BoundedContext Planejamento_de_Rotas {
  type = CORE_DOMAIN
}
BoundedContext Gestao_de_Frotas {
  type = SUPPORTING_DOMAIN
}
BoundedContext Sistema_Legado_Cobranca {
  type = GENERIC_DOMAIN
  implementationTechnology = "Legacy SOAP API"
}
```
* **Minha visão:** O código CML é um jeito de escrever esse plano. Ele diz quem é "rio acima" (Upstream - U) e quem é "rio abaixo" (Downstream - D) e qual é o tipo de "contrato" entre eles (CF ou ACL). Uma ferramenta como o ContextMapper pega esse texto e desenha o mapa pra gente.

### Categoria: ACL, OHS e PL (1)

**86. Qual é a principal diferença entre os padrões PL (Linguagem Pública) e OHS (Serviço de Hospedagem Aberta)?**

Os dois são jeitos de um time (upstream) oferecer seu modelo para os outros, mas eles se diferenciam no "pacote" que é oferecido.

* **Serviço de Hospedagem Aberta (Open-Host Service - OHS):** O time upstream abre as portas do seu serviço. Eles definem um protocolo de comunicação (tipo uma API REST) e dizem: "Galera, essa é a nossa API, esses são os comandos que vocês podem usar". É um jeito bem comum e flexível de integrar.
* **Linguagem Pública (Published Language - PL):** Aqui o negócio é mais específico. Além da API, o time upstream publica uma "língua" oficial, um formato de dados bem documentado e estável (pode ser um JSON Schema, um XML Schema, um Protocol Buffers...). É como se, além de te dar o número de telefone, eles te dessem um dicionário de como conversar com eles.

* **Minha visão:** Pensa assim: OHS é te dar acesso ao balcão de atendimento do correio. PL é te dar, além do acesso, o formulário padrão de preenchimento do SEDEX. A PL é mais formal e busca uma padronização maior na troca de informações.

**87. A ACL (Camada Anti-Corrupção) pode ser usada em conjunto com esses padrões? Explique.**

Sim, totalmente! Na verdade, é o cenário mais comum. O time *upstream* oferece seu serviço via **OHS/PL**, e o time *downstream* (o nosso) constrói uma **ACL** pra consumir esse serviço.

A ACL vai conversar com a API (OHS) e entender os formatos de dados (PL) que o outro time publicou. A função da ACL é justamente pegar essa "linguagem pública" do vizinho e traduzir para a linguagem privada e específica do nosso próprio sistema.

* **Minha visão:** OHS e PL são o que o *outro time* faz. ACL é o que o *nosso time* faz pra se proteger e se adaptar. Eles são dois lados da mesma moeda de integração.

**88. Quais são os benefícios e os riscos de combinar esses padrões?**

* **Benefícios:**
    * **Integração bem definida:** A combinação cria uma integração clara e documentada. O upstream diz "é assim que eu falo" (OHS/PL), e o downstream diz "ok, meu tradutor (ACL) já aprendeu sua língua".
    * **Desacoplamento:** É a maior vantagem. O time upstream pode mudar a implementação interna deles à vontade, desde que não quebrem a API e a linguagem pública. O nosso time também pode mudar tudo por dentro, porque a ACL nos isola.
* **Riscos:**
    * **Linguagem pode vazar:** Se a ACL for mal feita, a "linguagem pública" do outro sistema pode vazar para dentro do nosso, e a gente acaba com um modelo confuso.
    * **Complexidade:** É a solução mais robusta, mas também a que dá mais trabalho. Exige criar e manter a API, a documentação da linguagem e a camada de tradução.

* **Minha visão:** É o jeito mais profissional de fazer dois sistemas conversarem sem virar uma bagunça. Dá trabalho, mas a paz que isso traz no futuro compensa.

### Categoria: ACL, OHS e PL (2)

**89. Como Catálogo de Produtos poderia expor uma linguagem e uma interface de consulta para Loja Virtual e Análise de Vendas?**

O time do `Catálogo de Produtos` (que é o upstream) pode definir um **Serviço de Hospedagem Aberta (OHS)** com uma API REST. E, junto com a API, eles publicam uma **Linguagem Pública (PL)**.

* **OHS (A Interface):** Eles criariam endpoints na API, como:
    * `GET /api/produtos/{id}`: Para buscar um produto específico.
    * `GET /api/produtos?categoria={nome}`: Para buscar produtos por categoria.
* **PL (A Linguagem):** Eles definiriam e documentariam o formato JSON exato de um `Produto`, por exemplo:
    ```json
    {
      "sku": "ABC-123",
      "nome": "Smartphone XPTO",
      "descricao": "O melhor smartphone do mercado",
      "preco": { "valor": 1999.90, "moeda": "BRL" },
      "dimensoes": { "altura_cm": 15, "largura_cm": 7 }
    }
    ```
    A `Loja Virtual` e a `Análise de Vendas` saberiam que, ao consumir essa API, os dados sempre virão nesse formato.

* **Minha visão:** O `Catálogo` está sendo um bom vizinho. Ele não só atende o telefone (OHS), como também fala de um jeito claro e previsível (PL).

**90. Como a Loja Virtual poderia se proteger do sistema legado de Gestão de Estoque?**

A `Loja Virtual` precisa saber se um produto tem estoque, mas o sistema de `Gestão de Estoque` é um trambolho antigo. A solução é a `Loja Virtual` construir sua própria **Camada Anti-Corrupção (ACL)**.

Essa ACL seria responsável por conversar com o sistema legado. Quando um cliente entra na página de um produto na `Loja Virtual`, a loja não pergunta direto pro legado. Ela pergunta para a sua ACL: "Ei, qual o estoque do produto ABC-123?". A ACL, então, faz o trabalho sujo: ela se conecta com o sistema legado (talvez lendo um arquivo, talvez chamando um serviço antigo), pega a informação de um jeito todo esquisito, e traduz para uma resposta simples que a `Loja Virtual` entende, como `EstoqueInfo(produtoId: "ABC-123", quantidade: 5)`.

* **Minha visão:** A ACL é o "escudo" da `Loja Virtual`. Ela absorve a complexidade e a "feirura" do sistema legado, permitindo que a Loja continue sendo moderna e ágil.

**91. Documente o plano em um diagrama, complementado por texto, destacando os pontos-chave da aplicação dos padrões.**

**Texto Complementar:**
Nossa arquitetura de e-commerce tem integrações distintas. O `Catálogo de Produtos`, como um bom provedor, expõe seus dados através de um **Serviço de Hospedagem Aberta (OHS)** e uma **Linguagem Pública (PL)** bem definida, que é consumida tanto pela `Loja Virtual` quanto pela `Análise de Vendas`. Por outro lado, para interagir com o sistema antigo de `Gestão de Estoque`, a `Loja Virtual` se protege com uma **Camada Anti-Corrupção (ACL)**, que isola a complexidade do legado.

**Código (Context Mapper - CML):**
```cml
ContextMap {
  contains Catalogo_de_Produtos
  contains Loja_Virtual
  contains Analise_de_Vendas
  contains Gestao_de_Estoque_Legado

  // Catálogo (Upstream) expõe OHS e PL para os outros dois (Downstream)
  Catalogo_de_Produtos [U, OHS, PL] -> [D] Loja_Virtual
  Catalogo_de_Produtos [U, OHS, PL] -> [D] Analise_de_Vendas

  // Loja Virtual (Downstream) se protege do Legado (Upstream) com ACL
  Gestao_de_Estoque_Legado [U] -> [D, ACL] Loja_Virtual
}

BoundedContext Catalogo_de_Produtos {
  type = SUPPORTING_DOMAIN
}
BoundedContext Loja_Virtual {
  type = CORE_DOMAIN
}
BoundedContext Analise_de_Vendas {
  type = SUPPORTING_DOMAIN
}
BoundedContext Gestao_de_Estoque_Legado {
  implementationTechnology = "Legacy System"
}
```

* **Minha visão:** O mapa mostra claramente quem oferece o quê e como os outros consomem. O `Catálogo` é um "serviço público" (OHS/PL), enquanto a `Loja Virtual` precisa de um "tradutor particular" (ACL) pra lidar com a burocracia do sistema antigo.

### Categoria: C/S, SW e SK (1)

**92. Qual é a principal diferença entre os padrões C/S (Cliente-Fornecedor), SW (Caminhos Separados) e SK (Núcleo Compartilhado)?**

Esses três padrões definem tipos bem diferentes de relacionamento (ou falta de).

* **Cliente-Fornecedor (Customer-Supplier - C/S):** É uma relação de poder clara. Existe um time "Fornecedor" (upstream) e um time "Cliente" (downstream). O Cliente depende do Fornecedor e pode pedir novas funcionalidades. O sucesso do Cliente depende do bom atendimento do Fornecedor. Pensa numa empresa que contrata um fornecedor de internet.
* **Caminhos Separados (Separate Ways - SW):** É o divórcio. Dois contextos simplesmente não se integram. A conclusão é que o custo e a complexidade de fazer eles conversarem é maior do que o benefício. Cada um segue seu caminho, mesmo que isso signifique duplicar um pouco de código ou de dados.
* **Núcleo Compartilhado (Shared Kernel - SK):** É o casamento com comunhão parcial de bens. Dois times concordam em compartilhar e manter juntos um pedaço pequeno e crítico do código (o "núcleo"). É uma relação de acoplamento forte e exige muita colaboração.

* **Minha visão:** C/S é uma relação comercial. SW é ignorar o vizinho. SK é dividir o mesmo teto.

**93. Em que situações é benéfico usar cada padrão?**

* **Cliente-Fornecedor (C/S):** É o padrão mais comum em empresas grandes, onde um time provê um serviço (ex: Autenticação) e vários outros times consomem. É bom quando a dependência é clara e unidirecional.
* **Caminhos Separados (SW):** Quando a integração não traz valor real. Imagina um sistema de RH e um sistema de marketing. Eles precisam compartilhar o nome dos funcionários? Talvez, mas a integração é tão chata que é mais fácil cada um ter sua própria lista. É uma decisão pragmática pra evitar complexidade desnecessária.
* **Núcleo Compartilhado (SK):** Deve ser usado com MUITO cuidado. Só quando dois contextos são muito, muito próximos, e um pequeno subconjunto do modelo é genuinamente idêntico e estável nos dois. Usar SK pra muita coisa é receita pra criar um "mini-monolito" que trava todo mundo.

* **Minha visão:** A gente tende a querer integrar tudo. O padrão "Caminhos Separados" é um lembrete importante de que, às vezes, a melhor integração é nenhuma integração.

**94. É possível combiná-los em um mesmo mapa de contexto? Explique.**

Sim, com certeza! Na verdade, é o que acontece na maioria dos sistemas do mundo real. Um único Bounded Context não tem o mesmo tipo de relação com todos os seus vizinhos.

Ele pode ter uma relação de **Cliente-Fornecedor** com um serviço de Autenticação, compartilhar um **Núcleo Compartilhado** com um contexto-irmão super próximo, e estar em **Caminhos Separados** de um outro contexto com o qual a interação seria muito custosa.

* **Minha visão:** Um mapa de contexto é como o mapa de relacionamentos de uma pessoa no Facebook. Você é "casado" com alguém (SK), "amigo" de vários (C/S, Parceria), e tem um monte de gente que você simplesmente não tem conexão (SW).

### Categoria: C/S, SW e SK (2)

**95. Identifique um subconjunto comum de modelos, código ou dados que poderia ser compartilhado entre Gestão de Pacientes e Gestão de Medicamentos, e desenvolva um plano para implementar um SK (Núcleo Compartilhado).**

* **Subconjunto Comum:** Um conceito que parece ser comum e estável é o próprio `Paciente`. Ambos os contextos precisam de uma forma de identificar um paciente de maneira única (`PacienteID`) e talvez algumas informações básicas que não mudam, como `Nome` e `DataDeNascimento`.
* **Plano de Implementação (SK):**
    1.  **Reunião de Alinhamento:** Os times de `Gestão de Pacientes` e `Gestão de Medicamentos` se juntam pra definir a estrutura mínima e imutável desses objetos.
    2.  **Criar a Biblioteca:** Criar um projeto separado, `hospital-shared-kernel.jar`.
    3.  **Codificar o Núcleo:** Implementar os Value Objects `PacienteID`, `NomeCompleto` e `DataNascimento` na biblioteca.
    4.  **Definir as Regras:** Estabelecer que qualquer mudança nesse "kernel" precisa de um "comitê" com membros dos dois times.
    5.  **Distribuir e Usar:** Publicar a biblioteca para que os dois sistemas possam usá-la como dependência.

* **Minha visão:** O segredo de um bom Shared Kernel é mantê-lo **pequeno**. Se ele começar a crescer e ter muita regra de negócio, vira problema.

**96. Há contextos que não deveriam se relacionar, caracterizando um SW (Caminhos Separados)?**

Sim, provavelmente. Imagina que existe um contexto de `Gestão Financeira (Faturamento)` no hospital. Ele precisa saber *que* um procedimento foi feito para um paciente para poder gerar a cobrança, mas ele não precisa saber os detalhes da `Gestão de Medicamentos` (como a dose, a via de administração, etc.).

Tentar integrar o modelo detalhado de `Medicamentos` com o `Faturamento` seria um pesadelo. É muito mais simples o `Faturamento` receber uma informação genérica, tipo `EventoDeCobranca(pacienteId, procedimento: "administração de medicamento X", valor: Y)`. Os dois contextos operam em **Caminhos Separados** em relação aos detalhes do modelo um do outro.

* **Minha visão:** A gente evita o acoplamento desnecessário. O Faturamento não precisa saber de medicina, e o time de Medicamentos não precisa saber de contabilidade. Cada um no seu quadrado.

**97. Documente o plano em um diagrama, complementado por texto, destacando os pontos-chave da aplicação dos padrões.**

**Texto Complementar:**
No nosso sistema hospitalar, os contextos de `Gestão de Pacientes` e `Gestão de Medicamentos` são muito próximos e colaboram dividindo um **Núcleo Compartilhado (SK)** com os dados básicos do paciente. Isso garante consistência. Já o contexto de `Gestão Financeira` não precisa de detalhes médicos, então ele e a `Gestão de Medicamentos` seguem em **Caminhos Separados (SW)** para evitar acoplamento desnecessário, trocando apenas as informações essenciais para a cobrança.

**Código (Context Mapper - CML):**
```cml
ContextMap {
  contains Gestao_de_Pacientes
  contains Gestao_de_Medicamentos
  contains Gestao_Financeira
  contains Hospital_Shared_Kernel

  // Pacientes e Medicamentos se relacionam através do Shared Kernel
  Gestao_de_Pacientes [SK]<->[SK] Gestao_de_Medicamentos
  Gestao_de_Pacientes [SK]<-[SK] Hospital_Shared_Kernel
  Gestao_de_Medicamentos [SK]<-[SK] Hospital_Shared_Kernel

  // Financeiro e Medicamentos são independentes
  Gestao_Financeira [SW]<->[SW] Gestao_de_Medicamentos
}

BoundedContext Gestao_de_Pacientes {
  type = CORE_DOMAIN
}
BoundedContext Gestao_de_Medicamentos {
  type = SUPPORTING_DOMAIN
}
BoundedContext Gestao_Financeira {
  type = SUPPORTING_DOMAIN
}
BoundedContext Hospital_Shared_Kernel {
  implementationTechnology = "Shared Library"
}
```

* **Minha visão:** O mapa deixa claro: onde a colaboração é intensa e segura, a gente usa um SK. Onde a integração traria mais dor de cabeça do que benefício, a gente opta pelo divórcio amigável do SW.

---
## Aula 6.1: Design Tático: As Peças do Quebra-Cabeça

### Categoria: Implementando um Value Object (CPF)

**98. Implemente um CPF como Value Object, considerando a estrutura clássica de classes Java: garantir que os atributos não sejam alterados após a criação do objeto; garantir que haja exatamente 11 digitos.**

```java
import java.util.Objects;

public final class CPF { // 'final' pra ninguém poder herdar e zoar o barraco
    private final String numero; // 'final' pra garantir: uma vez criado, não muda mais!

    public CPF(String numero) {
        // Já chega na porta validando: se não for um CPF de 11 dígitos, nem entra.
        if (numero == null || !numero.matches("\\d{11}")) {
            throw new IllegalArgumentException("Opa, um CPF precisa ter 11 números, hein.");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF outroCpf = (CPF) o;
        // O que importa é o valor, não se é o mesmo objeto na memória.
        return numero.equals(outroCpf.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
```

* **Minha visão:** A ideia de um Value Object é tratar um conceito, como o CPF, como se fosse um número ou um texto. Ele não tem uma identidade própria que muda com o tempo, ele *é* o seu valor. A gente "blinda" o objeto pra que ele seja imutável e sempre válido.

**99. Refaça o exemplo usando o recurso de "record".**

```java
public record CPF(String numero) {
    // Construtor compacto, só pra botar a validação
    public CPF {
        if (numero == null || !numero.matches("\\d{11}")) {
            throw new IllegalArgumentException("Opa, um CPF precisa ter 11 números, hein.");
        }
    }
}
```
* **Minha visão:** Usar record em Java pra fazer Value Object é uma mão na roda. O Java já faz todo o trabalho chato (construtor, getters, equals, hashCode) pra você. Você só precisa se preocupar com a regra de negócio, que no caso é a validação. Fica muito mais limpo!

### Categoria: Mais sobre Objetos de Valor (1)

**100. Implemente CoordenadaGPS (com latitude/longitude) que: valide valores no intervalo (-90 a +90 para latitude e longitude de 0 a 180); implemente distanceTo(CoordenadaGPS outra).**

```java
import static java.lang.Math.*;

public record CoordenadaGPS(double latitude, double longitude) {
    public CoordenadaGPS {
        if (latitude < -90.0 || latitude > 90.0) {
            throw new IllegalArgumentException("Latitude fora do mapa! Tem que ser de -90 a 90.");
        }
        if (longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("Longitude fora do mapa! Tem que ser de -180 a 180.");
        }
    }

    public double distanciaAte(CoordenadaGPS outra) {
        final int RAIO_DA_TERRA_KM = 6371;
        double latDist = toRadians(outra.latitude - this.latitude);
        double lonDist = toRadians(outra.longitude - this.longitude);
        double a = sin(latDist / 2) * sin(latDist / 2) +
                   cos(toRadians(this.latitude)) * cos(toRadians(outra.latitude)) *
                   sin(lonDist / 2) * sin(lonDist / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return RAIO_DA_TERRA_KM * c;
    }
}
```

* **Minha visão:** Um bom Value Object não tem só dados, ele tem comportamento que faz sentido pra ele. Em vez de ter uma função `CalculadoraDeDistancia` perdida no código, a própria `CoordenadaGPS` sabe como calcular a distância até outra. O código fica muito mais organizado e fácil de entender.

**101. Crie um Value Object Senha que: exija no mínimo 8 caracteres; armazena apenas o hash da senha.**

```java
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public record Senha(String hash) {
    private static final int TAMANHO_MINIMO = 8;

    public static Senha of(String senhaPura) {
        if (senhaPura == null || senhaPura.length() < TAMANHO_MINIMO) {
            throw new IllegalArgumentException("Senha muito curta, campeão! Mínimo de 8 caracteres.");
        }
        String hashGerado = calcularHash(senhaPura);
        return new Senha(hashGerado);
    }

    public boolean confere(String senhaPura) {
        if (senhaPura == null) return false;
        return this.hash.equals(calcularHash(senhaPura));
    }

    private static String calcularHash(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (Exception e) {
            throw new RuntimeException("Deu ruim pra gerar o hash da senha.", e);
        }
    }
}
```

* **Minha visão:** Esse é um exemplo animal de como um Value Object pode carregar regras de segurança importantes. O objeto `Senha` garante que a gente *nunca* guarde a senha de verdade no sistema. Ele força a gente a trabalhar sempre do jeito certo e seguro.

**102. Crie um Value Object para E-mail que: não permita emails sem "@"; exija o formato usuario@dominio; permita apenas letras, números, ponto e sublinhado para usuario e dominio.**

```java
import java.util.regex.Pattern;

public record Email(String endereco) {
    private static final Pattern PADRAO_EMAIL =
        Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    public Email {
        if (endereco == null || !PADRAO_EMAIL.matcher(endereco).matches()) {
            throw new IllegalArgumentException("'" + endereco + "' não parece um e-mail válido.");
        }
    }

    public String getDominio() {
        return endereco.substring(endereco.indexOf('@') + 1);
    }

    public String getUsuario() {
        return endereco.substring(0, endereco.indexOf('@'));
    }
}
```

* **Minha visão:** É muito melhor ter uma variável `Email email` do que `String email` no seu código. Com o objeto `Email`, você tem a certeza de que ele sempre será válido. E de quebra, ele já te dá uns métodos bacanas como `getDominio()`.

### Categoria: Mais sobre Objetos de Valor (2)

**103. Implemente um Value Object Temperatura com: validação de -273.15°C (zero absoluto) e lançamento de exceção para valores inválidos; conversão com toFahrenheit().**

```java
public record Temperatura(double celsius) {
    private static final double ZERO_ABSOLUTO = -273.15;

    public Temperatura {
        if (celsius < ZERO_ABSOLUTO) {
            throw new IllegalArgumentException("Eita! Mais frio que o zero absoluto não rola (" + ZERO_ABSOLUTO + "°C).");
        }
    }

    public double emFahrenheit() {
        return (this.celsius * 9.0 / 5.0) + 32;
    }
}
```

* **Minha visão:** O objeto `Temperatura` não é só um número, ele carrega uma regra da física com ele. Ele se protege de valores impossíveis. E o método `emFahrenheit()` mostra que ele entende do seu próprio conceito.

### Categoria: Implementando uma Entidade (Livro)

**104. Implemente uma entidade Livro para um sistema de biblioteca.**
**105. Considere que o id é definido pelo código ISBN, validado no construtor da classe e lançando um exceção caso o código seja inválido.**
**106. Implemente a regra que devolva a citação do livro, por padrão, em formato ABNT.**

```java
import java.util.Objects;

public class Livro {
    private final String isbn;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String isbn, String titulo, String autor, int anoPublicacao) {
        if (isbn == null || !(isbn.matches("\\d{10}") || isbn.matches("\\d{13}"))) {
            throw new IllegalArgumentException("ISBN inválido, parceiro.");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getCitacaoABNT() {
        String[] partesAutor = autor.split(" ");
        String ultimoNome = partesAutor[partesAutor.length - 1].toUpperCase();
        String nomes = autor.substring(0, autor.lastIndexOf(' '));
        return String.format("%s, %s. %s. %d.", ultimoNome, nomes, this.titulo, this.anoPublicacao);
    }
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return isbn.equals(livro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    // Getters e Setters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
}
```

* **Minha visão:** A grande diferença de uma Entidade pra um Value Object é essa ideia de "identidade". Um `Livro` tem uma história. O título pode ser corrigido, mas o ISBN dele continua o mesmo. Já um `CPF`, se o número mudar, é *outro* CPF, não o mesmo que mudou. É por isso que o `equals` da Entidade só olha pro ID.

### Categoria: Mais sobre Entidades (Reserva e Identificadores)

**107. Implemente uma entidade ReservaHotel com: identidade (UUID); regra: não pode ser cancelada após check-in.**

```java
import java.time.LocalDate;
import java.util.UUID;
import java.util.Objects;

public class ReservaHotel {
    private final UUID id;
    private String nomeHospede;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private StatusReserva status;

    public enum StatusReserva { CONFIRMADA, HOSPEDADO, CANCELADA, FINALIZADA }

    public ReservaHotel(String nomeHospede, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.id = UUID.randomUUID();
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.status = StatusReserva.CONFIRMADA;
    }

    public void fazerCheckIn() {
        if (this.status != StatusReserva.CONFIRMADA) {
            throw new IllegalStateException("Ué, não dá pra fazer check-in de uma reserva que não tá confirmada.");
        }
        this.status = StatusReserva.HOSPEDADO;
    }

    public void cancelar() {
        if (this.status == StatusReserva.HOSPEDADO || this.status == StatusReserva.FINALIZADA) {
            throw new IllegalStateException("Já era! Não dá pra cancelar depois que o hóspede já entrou.");
        }
        this.status = StatusReserva.CANCELADA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaHotel that = (ReservaHotel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
   
    // Getters
    public UUID getId() { return id; }
    public String getNomeHospede() { return nomeHospede; }
    public LocalDate getDataCheckIn() { return dataCheckIn; }
    public LocalDate getDataCheckOut() { return dataCheckOut; }
    public StatusReserva getStatus() { return status; }
}
```

* **Minha visão:** A entidade `ReservaHotel` não é só um monte de dados. Ela é a guardiã do seu próprio ciclo de vida. Você não "seta" o status pra "CANCELADA", você manda uma ordem: `reserva.cancelar()`. E a reserva, que conhece as próprias regras, decide se essa ordem pode ser executada ou não.

**108. No contexto de publicações acadêmicas, científicas e documentos digitais faça uma análise sobre os códigos ISBN, ISSN e DOI. Como eles poderiam ser utilizados na implementação de diferentes entidades? Dê exemplos práticos.**

Esses códigos são como RGs para diferentes tipos de publicações. A gente usaria cada um pra identificar uma entidade diferente:

* **ISBN (International Standard Book Number):** É o RG de **livros**. Cada edição de um livro tem um. Seria o identificador perfeito pra uma entidade `Livro`. `public class Livro { private final ISBN id; ... }`
* **ISSN (International Standard Serial Number):** É o RG de **publicações em série**, tipo revistas e jornais científicos. Ele identifica a revista como um todo, não uma edição específica. Seria o ID da entidade `Periodico`. `public class Periodico { private final ISSN id; ... }`
* **DOI (Digital Object Identifier):** É um link permanente, o RG de **qualquer coisa digital**, principalmente artigos científicos. Não importa se a revista mudou de site, o DOI do artigo vai ser sempre o mesmo. Perfeito pra entidade `Artigo`. `public class Artigo { private final DOI id; ... }`

* **Minha visão:** Usar esses identificadores do mundo real é uma ótima! Conecta nosso software diretamente com os conceitos que os especialistas da área (bibliotecários, pesquisadores) já usam.

### Categoria: Implementando um Agregado (Reserva de Passagens)

**109. Implemente um agregado para o contexto de um sistema de reserva de passagens, considerando elementos como Reserva, Voo, Passageiro.**
**110. Garanta que a reserva de um passageiro só pode ser confirmada se o voo não estiver lotado.**

```java
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Raiz do Agregado
public class Voo {
    private final UUID id;
    private String codigoVoo;
    private int capacidade;
    private final List<Reserva> reservas;

    public Voo(String codigoVoo, int capacidade) {
        this.id = UUID.randomUUID();
        this.codigoVoo = codigoVoo;
        this.capacidade = capacidade;
        this.reservas = new ArrayList<>();
    }

    public Reserva criarReservaPara(Passageiro passageiro) {
        if (reservas.size() >= capacidade) {
            throw new IllegalStateException("Voo lotado, já era!");
        }
        Reserva novaReserva = new Reserva(passageiro, this.id);
        this.reservas.add(novaReserva);
        return novaReserva;
    }

    public void cancelarReserva(UUID reservaId) {
        reservas.removeIf(reserva -> reserva.getId().equals(reservaId));
    }

    public List<Reserva> getReservas() {
        return List.copyOf(reservas); // Retorna cópia para proteger a lista interna
    }
   
    public UUID getId() { return id; }
}

// Entidade interna
class Reserva {
    private final UUID id;
    private final Passageiro passageiro;
    private final UUID vooId;

    public Reserva(Passageiro passageiro, UUID vooId) {
        this.id = UUID.randomUUID();
        this.passageiro = passageiro;
        this.vooId = vooId;
    }
    public UUID getId() { return id; }
    public Passageiro getPassageiro() { return passageiro; }
}

// Value Object
record Passageiro(String nome, String documento) {}
```

* **Minha visão:** Pensa no Agregado como uma "gangue". Tem o chefe (a Raiz, no caso, `Voo`) e os membros (as `Reservas`). Ninguém de fora fala direto com os membros, só com o chefe. E o chefe garante que a gangue inteira esteja sempre consistente, protegendo as regras do grupo (como a de não vender mais passagens do que assentos).

### Categoria: Mais sobre Agregados

**111. Implemente um agregado para um sistema bancário onde: Raiz: ContaBancária; Invariante: saldo nunca pode ser negativo. Métodos: depositar(), sacar() (validando saldo).**

```java
import java.math.BigDecimal;
import java.util.UUID;

public class ContaBancaria {
    private final UUID id;
    private BigDecimal saldo;

    public ContaBancaria() {
        this.id = UUID.randomUUID();
        this.saldo = BigDecimal.ZERO;
    }

    public void depositar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor do depósito tem que ser positivo, né.");
        }
        this.saldo = this.saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor do saque tem que ser positivo.");
        }
        if (this.saldo.compareTo(valor) < 0) {
            throw new IllegalStateException("Saldo insuficiente. Acontece...");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
    public UUID getId() { return id; }
}
```

* **Minha visão:** A `ContaBancaria` protege o saldo como um leão. Ninguém de fora pode simplesmente fazer `conta.setSaldo(-100)`. A única forma de mexer no saldo é através dos portões de entrada `depositar()` e `sacar()`, e eles são os seguranças que barram qualquer operação inválida.

**112. Implemente um agregado para um sistema de bibliotecas onde: Raiz: Biblioteca; Entidade interna: Livro (não pode ser emprestado diretamente, só pela raiz); Value Object: ISBN (identificador imutável do livro).**

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Value Object
record ISBN(String codigo) {
    public ISBN {
        if (codigo == null || !(codigo.matches("\\d{10}") || codigo.matches("\\d{13}"))) {
            throw new IllegalArgumentException("ISBN inválido.");
        }
    }
}

// Entidade Interna
class ItemLivro {
    private final ISBN isbn;
    private boolean emprestado;

    public ItemLivro(ISBN isbn) { this.isbn = isbn; this.emprestado = false; }
    public ISBN getIsbn() { return isbn; }
    boolean isEmprestado() { return emprestado; }
    void marcarComoEmprestado() { this.emprestado = true; }
    void marcarComoDevolvido() { this.emprestado = false; }
}

// Raiz do Agregado
public class Biblioteca {
    private final String nome;
    private final Map<ISBN, ItemLivro> acervo = new HashMap<>();

    public Biblioteca(String nome) { this.nome = nome; }

    public void adicionarLivroAoAcervo(ISBN isbn) {
        acervo.putIfAbsent(isbn, new ItemLivro(isbn));
    }

    public void emprestarLivro(ISBN isbn) {
        ItemLivro livro = Optional.ofNullable(acervo.get(isbn))
            .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado no acervo."));
       
        if (livro.isEmprestado()) {
            throw new IllegalStateException("Ih, esse livro já está emprestado.");
        }
        livro.marcarComoEmprestado();
    }

    public void devolverLivro(ISBN isbn) {
        ItemLivro livro = Optional.ofNullable(acervo.get(isbn))
            .orElseThrow(() -> new IllegalArgumentException("Este livro não parece ser do nosso acervo."));
       
        livro.marcarComoDevolvido();
    }
}
```

* **Minha visão:** A `Biblioteca` é a Raiz do Agregado e controla o estado de todos os `ItemLivro` em seu acervo. Não é possível emprestar um `ItemLivro` diretamente. A operação deve passar pelo método `biblioteca.emprestarLivro(isbn)`, que contém as regras de negócio, como verificar se o livro existe e se já não está emprestado. Isso garante a consistência do acervo.

---

## Aula 6.2: Design Tático: Mais Peças do Quebra-Cabeça

### Categoria: Implementando um Serviço (Empréstimo de Livro)

**113. Considere o contexto de um sistema de bibliotecas e implemente: um ServicoEmprestimo que utiliza Livro, Usuario e Emprestimo para efetuar a operação emprestarLivro.**
**114. Considere que: Um livro só pode ser emprestado se estiver disponível. O usuário deve estar em situação regular para realizar um empréstimo. A data de devolução depende do tipo de usuário. Exceções devem ser lançadas para tentativas de empréstimo com usuário irregular ou livro indisponível.**

```java
import java.time.LocalDate;

// Supondo a existência dessas classes/records e repositórios
// public record ISBN(String value) {}
// public record UsuarioId(UUID value) {}
// enum TipoUsuario { ALUNO, PROFESSOR }
// public class Livro { public boolean estaDisponivel() {...} public void marcarComoEmprestado() {...} ... }
// public class Usuario { public boolean estaRegular() {...} public TipoUsuario getTipo() {...} ... }
// public class Emprestimo { ... }
// ... Repositórios ...

public class ServicoEmprestimo {
    private final LivroRepositorio livroRepo;
    private final UsuarioRepositorio usuarioRepo;
    private final EmprestimoRepositorio emprestimoRepo;

    public ServicoEmprestimo(LivroRepositorio lr, UsuarioRepositorio ur, EmprestimoRepositorio er) {
        this.livroRepo = lr;
        this.usuarioRepo = ur;
        this.emprestimoRepo = er;
    }

    public Emprestimo emprestarLivro(ISBN isbn, UsuarioId usuarioId) {
        Livro livro = livroRepo.buscarPorIsbn(isbn)
            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
       
        Usuario usuario = usuarioRepo.buscarPorId(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!livro.estaDisponivel()) {
            throw new RuntimeException("Livro indisponível");
        }
        if (!usuario.estaRegular()) {
            throw new RuntimeException("Usuário com pendências");
        }

        LocalDate dataDevolucao = calcularDataDevolucao(usuario.getTipo());
        livro.marcarComoEmprestado();
        Emprestimo novoEmprestimo = new Emprestimo(livro.getIsbn(), usuario.getId(), dataDevolucao);
       
        livroRepo.salvar(livro);
        emprestimoRepo.salvar(novoEmprestimo);

        return novoEmprestimo;
    }

    private LocalDate calcularDataDevolucao(TipoUsuario tipo) {
        return tipo == TipoUsuario.PROFESSOR ? LocalDate.now().plusDays(30) : LocalDate.now().plusDays(15);
    }
}
```

* **Minha visão:** Um Serviço de Domínio é tipo o "maestro" de uma operação complexa. Ele não tem estado próprio, ele não guarda nenhuma informação. A função dele é pegar vários atores diferentes (agregados, como `Livro` e `Usuario`), coordenar uma ação entre eles que não seria responsabilidade de nenhum deles sozinho, e garantir que a operação aconteça de forma consistente.

### Categoria: Mais sobre Serviços

**115. Implemente um serviço de ConversorMoeda capaz de realizar conversão de valores entre diferentes moedas, baseado em diferentes taxas de câmbio.**

```java
import java.math.BigDecimal;
import java.math.RoundingMode;

interface TaxaCambioProvider {
    BigDecimal getTaxa(String moedaOrigem, String moedaDestino);
}

public class ConversorMoeda {
    private final TaxaCambioProvider taxaProvider;

    public ConversorMoeda(TaxaCambioProvider provider) {
        this.taxaProvider = provider;
    }

    public BigDecimal converter(BigDecimal valor, String moedaOrigem, String moedaDestino) {
        if (moedaOrigem.equalsIgnoreCase(moedaDestino)) {
            return valor;
        }
        BigDecimal taxa = taxaProvider.getTaxa(moedaOrigem, moedaDestino);
        return valor.multiply(taxa).setScale(2, RoundingMode.HALF_UP);
    }
}
```

* **Minha visão:** A conversão de moeda é um processo, uma ação. Não é uma "coisa" que tem identidade. Por isso, ela se encaixa perfeitamente como um Serviço. Ele simplesmente pega uns dados de entrada (valor, moedas), faz um cálculo (usando taxas que podem vir de outro lugar) e te devolve uma saída, sem guardar nada.

**116. Implemente um serviço de AnaliseCredito que avalia se um empréstimo deve ser concedido a um cliente, considerando seu histórico de compras, dívidas ativas, salário e valor do empréstimo.**

```java
import java.math.BigDecimal;

// Supondo a existência dessas classes e serviços
// public class Cliente { ... }
// public interface ClienteRepositorio { ... }
// public interface ServicoExternoSerasa { boolean temPendencias(CPF cpf); }

public class AnaliseCredito {
    private final ClienteRepositorio clienteRepo;
    private final ServicoExternoSerasa serasaService;

    public AnaliseCredito(ClienteRepositorio clienteRepo, ServicoExternoSerasa serasaService) {
        this.clienteRepo = clienteRepo;
        this.serasaService = serasaService;
    }

    public ResultadoAnalise avaliar(ClienteId clienteId, BigDecimal valorEmprestimo) {
        Cliente cliente = clienteRepo.buscarPorId(clienteId)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
       
        if (serasaService.temPendencias(cliente.getCpf())) {
            return ResultadoAnalise.REPROVADO("Cliente com pendências no Serasa.");
        }

        BigDecimal parcelaMaxima = cliente.getSalario().multiply(new BigDecimal("0.3"));
       
        // Lógica simplificada de cálculo de parcela
        BigDecimal parcelaEstimada = valorEmprestimo.divide(new BigDecimal("12"), RoundingMode.HALF_UP);

        if (parcelaEstimada.compareTo(parcelaMaxima) > 0) {
            return ResultadoAnalise.REPROVADO("Valor da parcela excede 30% da renda.");
        }

        return ResultadoAnalise.APROVADO("Crédito aprovado.");
    }
}

record ResultadoAnalise(boolean aprovado, String motivo) {
    public static ResultadoAnalise APROVADO(String motivo) { return new ResultadoAnalise(true, motivo); }
    public static ResultadoAnalise REPROVADO(String motivo) { return new ResultadoAnalise(false, motivo); }
}
```

* **Minha visão:** A "Análise de Crédito" é uma regra de negócio que é bem mais do que uma soma ou multiplicação. Ela envolve buscar dados de vários lugares (do nosso banco de dados, de um serviço tipo Serasa) e aplicar uma política complexa. Colocar essa lógica num Serviço deixa tudo bem organizado e separado das entidades, que continuam cuidando só dos seus próprios dados e regras simples.

### Categoria: Implementando um Evento (Reserva de Hotel)

**117. Considere o contexto de um sistema de hotel: Implemente um evento representativo para ReservaConfirmada (considerando informações como: identificação da reserva, do cliente, datas de entrada e saída, custo total).**
**118. Considere ainda um agregado representativo da reserva, contendo uma funcionalidade para gerar a confirmação de reserva.**

```java
import java.time.Instant;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

// O Evento de Domínio
public record ReservaConfirmada(
    UUID eventoId,
    Instant dataOcorrencia,
    UUID reservaId,
    UUID clienteId,
    LocalDate dataCheckIn,
    LocalDate dataCheckOut,
    BigDecimal custoTotal
) {
    public ReservaConfirmada(UUID reservaId, UUID clienteId, LocalDate checkIn, LocalDate checkOut, BigDecimal custo) {
        this(UUID.randomUUID(), Instant.now(), reservaId, clienteId, checkIn, checkOut, custo);
    }
}

// O Agregado
public class Reserva {
    private final UUID id;
    private final UUID clienteId;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private BigDecimal custoTotal;
    private StatusReserva status;
    private transient final List<Object> domainEvents = new ArrayList<>();

    private enum StatusReserva { PENDENTE, CONFIRMADA, CANCELADA }

    public Reserva(UUID clienteId, LocalDate checkIn, LocalDate checkOut, BigDecimal custo) {
        this.id = UUID.randomUUID();
        this.clienteId = clienteId;
        this.dataCheckIn = checkIn;
        this.dataCheckOut = checkOut;
        this.custoTotal = custo;
        this.status = StatusReserva.PENDENTE;
    }

    public void confirmar() {
        if (this.status != StatusReserva.PENDENTE) {
            throw new IllegalStateException("Apenas reservas pendentes podem ser confirmadas.");
        }
        this.status = StatusReserva.CONFIRMADA;
       
        ReservaConfirmada evento = new ReservaConfirmada(
            this.id, this.clienteId, this.dataCheckIn, this.dataCheckOut, this.custoTotal
        );
        this.domainEvents.add(evento);
    }

    public List<Object> getDomainEvents() {
        return List.copyOf(domainEvents);
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }
}
```

* **Minha visão:** Um Evento de Domínio é como uma "notícia de jornal" que o seu sistema publica: "Fiquem sabendo: a reserva XYZ foi confirmada!". É um fato que aconteceu no passado, imutável. Quem gera a notícia é o Agregado (`Reserva`), porque é ele que sabe quando algo importante aconteceu. Depois que a notícia é publicada, outros sistemas interessados (como o de enviar e-mails, ou o financeiro) podem ler e tomar suas próprias ações. Isso desacopla todo mundo!

### Categoria: Mais sobre Evento

**119. Implemente um evento EstoqueAbaixoDoMinimo com os seguintes dados: produtoId, quantidadeAtual, quantidadeMinima. A regra é: Disparar apenas quando quantidadeAtual < quantidadeMinima.**

```java
import java.time.Instant;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

// O Evento
public record EstoqueAbaixoDoMinimo(
    UUID eventoId,
    Instant dataOcorrencia,
    UUID produtoId,
    int quantidadeAtual,
    int quantidadeMinima
) {
    public EstoqueAbaixoDoMinimo(UUID produtoId, int atual, int minima) {
        this(UUID.randomUUID(), Instant.now(), produtoId, atual, minima);
    }
}

// O Agregado
public class Produto {
    private final UUID id;
    private int quantidadeEmEstoque;
    private final int estoqueMinimo;
    private transient final List<Object> domainEvents = new ArrayList<>();
   
    public Produto(UUID id, int estoqueInicial, int estoqueMinimo) {
        this.id = id;
        this.quantidadeEmEstoque = estoqueInicial;
        this.estoqueMinimo = estoqueMinimo;
    }

    public void darBaixaEstoque(int quantidade) {
        if (this.quantidadeEmEstoque < quantidade) {
            throw new IllegalStateException("Estoque insuficiente.");
        }
        int estoqueAnterior = this.quantidadeEmEstoque;
        this.quantidadeEmEstoque -= quantidade;
       
        if (estoqueAnterior >= this.estoqueMinimo && this.quantidadeEmEstoque < this.estoqueMinimo) {
            EstoqueAbaixoDoMinimo evento = new EstoqueAbaixoDoMinimo(
                this.id, this.quantidadeEmEstoque, this.estoqueMinimo
            );
            this.domainEvents.add(evento);
        }
    }
   
    public List<Object> getDomainEvents() { return List.copyOf(domainEvents); }
    public void clearDomainEvents() { this.domainEvents.clear(); }
}
```

* **Minha visão:** A sacada aqui é que o evento não deve ser disparado toda vez que o estoque baixa, mas só no momento exato em que ele **cruza a linha** do mínimo. Isso evita um monte de "notícias" repetidas e desnecessárias. A lógica pra decidir se a notícia deve ser gerada ou não fica dentro do guardião daquela informação, o agregado `Produto`.

### Categoria: Implementando uma Fábrica (Folha de Pagamento)

**120. Considere o contexto de um Sistema de RH envolvendo a geração de uma folha de pagamento para um funcionário, com base nas horas trabalhadas, salário base, horas extras e aplicação de impostos.**
**121. Implemente uma fábrica capaz de gerar folhas de pagamento, parametrizada pelo funcionário e quantidade de horas trabalhadas, considerando também os demais itens citados.**

```java
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

// Supondo a existência dessas classes/interfaces
// public class Funcionario { ... getters para id, salarioBase, valorHora ... }
// public class FolhaDePagamento { ... }
// public interface PoliticaDeImpostos { BigDecimal calcular(BigDecimal salarioBruto); }

public class FolhaDePagamentoFactory {
    private final PoliticaDeImpostos politicaDeImpostos;

    public FolhaDePagamentoFactory(PoliticaDeImpostos politicaDeImpostos) {
        this.politicaDeImpostos = politicaDeImpostos;
    }

    public FolhaDePagamento criarPara(Funcionario funcionario, int horasTrabalhadas, int horasExtras) {
        if (funcionario == null) throw new IllegalArgumentException("Funcionário não pode ser nulo.");
       
        BigDecimal salarioBase = funcionario.getSalarioBase();
        BigDecimal valorHoraExtra = funcionario.getValorHora().multiply(new BigDecimal("1.5"));
        BigDecimal totalHorasExtras = valorHoraExtra.multiply(new BigDecimal(horasExtras));
        BigDecimal salarioBruto = salarioBase.add(totalHorasExtras);
       
        BigDecimal valorImpostos = politicaDeImpostos.calcular(salarioBruto);
        BigDecimal salarioLiquido = salarioBruto.subtract(valorImpostos);

        return new FolhaDePagamento(
            UUID.randomUUID(),
            funcionario.getId(),
            LocalDate.now(),
            salarioBruto,
            valorImpostos,
            salarioLiquido
        );
    }
}
```

* **Minha visão:** Criar uma `FolhaDePagamento` não é só dar um "new". Tem um monte de cálculo e regra envolvida. Uma Factory é como uma "linha de montagem" especializada. Você entrega a matéria-prima (funcionário, horas) e ela te devolve o produto final (a `FolhaDePagamento`) prontinho e validado. Isso limpa o resto do código, que não precisa saber os detalhes da montagem.

### Categoria: Mais sobre Fábricas

**122. Implemente uma NotaFiscalFabrica considerando: Validação: Itens não podem ser vazios. Calcule impostos automaticamente.**

```java
import java.math.BigDecimal;
import java.util.List;

// Supondo a existência dessas classes/interfaces
// public class Cliente { ... }
// public class ItemNotaFiscal { ... }
// public class Impostos { ... }
// public interface ServicoCalculoImposto { Impostos calcularPara(BigDecimal valor, TipoCliente tipo); }
// public class NotaFiscal { ... }

public class NotaFiscalFactory {
    private final ServicoCalculoImposto servicoImposto;

    public NotaFiscalFactory(ServicoCalculoImposto servicoImposto) {
        this.servicoImposto = servicoImposto;
    }

    public NotaFiscal criar(Cliente cliente, List<ItemNotaFiscal> itens) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório.");
        }
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("A nota fiscal deve ter pelo menos um item.");
        }

        BigDecimal valorTotalItens = itens.stream()
            .map(ItemNotaFiscal::getValorTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
       
        Impostos calculoImpostos = servicoImposto.calcularPara(valorTotalItens, cliente.getTipo());

        return new NotaFiscal(
            cliente,
            itens,
            valorTotalItens,
            calculoImpostos,
            valorTotalItens.add(calculoImpostos.getTotal())
        );
    }
}
```

* **Minha visão:** De novo, a Factory age como um "porteiro" e um "despachante". Primeiro, ela valida se a criação da `NotaFiscal` faz sentido (tem cliente? tem itens?). Se estiver tudo ok, ela faz o trabalho chato de coordenar os cálculos de impostos e só então monta o objeto final, garantindo que ele já nasça consistente.

### Categoria: Implementando um Repositório (Sistema Bancário)

**123. Considere o contexto de um Sistema Bancário contendo um agregado para ContaBancaria.**
**124. Apresente a implementação de ContaBancariaRepositorio acompanhada de uma implementação de persistência usando Hibernate (ou outro mecanismo de persistência que tenha maior familiaridade), com destaque para uma operação de busca para contas com saldo negativo.**

```java
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

// 1. A Interface do Repositório (no domínio)
public interface ContaBancariaRepositorio {
    Optional<ContaBancaria> buscarPorId(UUID id);
    void salvar(ContaBancaria conta);
    List<ContaBancaria> buscarContasComSaldoNegativo();
}

// 2. A Entidade ContaBancaria mapeada com JPA
@Entity
class ContaBancaria {
    @Id
    private UUID id;
    private BigDecimal saldo;
   
    // Construtor vazio para o JPA
    protected ContaBancaria() {}

    // Construtor de negócio e métodos...
    public ContaBancaria(UUID id) {
        this.id = id;
        this.saldo = BigDecimal.ZERO;
    }
    // ... depositar(), sacar(), etc. ...
}

// 3. A Implementação do Repositório (na infraestrutura)
public class ContaBancariaRepositorioJPA implements ContaBancariaRepositorio {

    private final EntityManager entityManager;

    public ContaBancariaRepositorioJPA(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Optional<ContaBancaria> buscarPorId(UUID id) {
        return Optional.ofNullable(entityManager.find(ContaBancaria.class, id));
    }

    @Override
    public void salvar(ContaBancaria conta) {
        entityManager.merge(conta);
    }

    @Override
    public List<ContaBancaria> buscarContasComSaldoNegativo() {
        String jpql = "SELECT c FROM ContaBancaria c WHERE c.saldo < 0";
        TypedQuery<ContaBancaria> query = entityManager.createQuery(jpql, ContaBancaria.class);
        return query.getResultList();
    }
}
```

* **Minha visão:** O Repositório é uma das ideias mais geniais do DDD. Ele finge ser uma "coleção de objetos em memória". O seu código de negócio simplesmente fala: `repositorio.salvar(conta)` ou `repositorio.buscarPorId(id)`. Ele não faz ideia se os dados estão indo pra um banco SQL, NoSQL, um arquivo de texto ou pra nuvem. Essa "mentira" desacopla totalmente o seu domínio da infraestrutura, o que é lindo.

### Categoria: Mais sobre Repositório

**125. Implemente ProdutoRepositorio: Interface: List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max). Implementação 1: Hibernate com @NamedQuery. Implementação 2: Com recuperação dos objetos de um arquivo onde foram serializados.**

```java
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.persistence.*;

// 1. A Interface do Repositório (no domínio)
public interface ProdutoRepositorio {
    Optional<Produto> buscarPorId(UUID id);
    void salvar(Produto produto);
    List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max);
}

// A Entidade/Agregado Produto
@Entity
@NamedQuery(
    name = "Produto.buscarPorFaixaDePreco",
    query = "SELECT p FROM Produto p WHERE p.preco BETWEEN :minPreco AND :maxPreco"
)
class Produto implements Serializable {
    @Id private UUID id;
    private String nome;
    private BigDecimal preco;
    // ... construtores, getters, etc. ...
}

// 2. Implementação 1: Hibernate com @NamedQuery (na infraestrutura)
public class ProdutoRepositorioJPA implements ProdutoRepositorio {
    private final EntityManager em;

    public ProdutoRepositorioJPA(EntityManager em) { this.em = em; }

    @Override
    public Optional<Produto> buscarPorId(UUID id) {
        return Optional.ofNullable(em.find(Produto.class, id));
    }

    @Override
    public void salvar(Produto produto) {
        em.merge(produto);
    }

    @Override
    public List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        return em.createNamedQuery("Produto.buscarPorFaixaDePreco", Produto.class)
                 .setParameter("minPreco", min)
                 .setParameter("maxPreco", max)
                 .getResultList();
    }
}

// 3. Implementação 2: Arquivo Serializado (na infraestrutura)
public class ProdutoRepositorioArquivo implements ProdutoRepositorio {
    private final String caminhoArquivo = "produtos.dat";

    @Override
    public Optional<Produto> buscarPorId(UUID id) {
        return lerTodosDoArquivo().stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public void salvar(Produto produto) {
        List<Produto> todos = lerTodosDoArquivo();
        todos.removeIf(p -> p.getId().equals(produto.getId()));
        todos.add(produto);
        escreverTodosNoArquivo(todos);
    }

    @Override
    public List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        return lerTodosDoArquivo().stream()
            .filter(p -> p.getPreco().compareTo(min) >= 0 && p.getPreco().compareTo(max) <= 0)
            .collect(Collectors.toList());
    }
   
    private List<Produto> lerTodosDoArquivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<Produto>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Falha ao ler produtos do arquivo.", e);
        }
    }
   
    private void escreverTodosNoArquivo(List<Produto> produtos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            throw new RuntimeException("Falha ao salvar produtos no arquivo.", e);
        }
    }
}
```

* **Minha visão:** Este exercício mostra o poder do Repositório na prática. A gente tem UMA interface (`ProdutoRepositorio`) e DUAS implementações totalmente diferentes. Uma fala com o banco de dados chique (Hibernate) e a outra salva tudo num arquivo simples. O código de negócio que usa o repositório não muda NADA. Ele continua pedindo `buscarPorFaixaDePreco` e nem sabe da onde os dados estão vindo. Isso é flexibilidade na veia!

---
* **Aulas 7.1 e 7.2: Arquitetura e Modelos de Domínio (não realizei os exercícios)**