Para cumprir o desafio proposto o programa deve seguir as seguintes etapas:

Leitura do arquivo de entrada: O programa deve ler o arquivo input.txt que contém as etapas de produção. Cada linha do arquivo representa uma etapa, e o programa deve extrair o título da etapa e sua duração em minutos.

Organização das etapas: Com base nas restrições de horário e sequência das etapas, o programa deve organizar as etapas em linhas de montagem. Cada linha de montagem começa às 9:00 e segue a ordem das etapas até o meio-dia para o período da manhã, depois do almoço até o horário de ginástica laboral.

Cálculo do horário das etapas: O programa precisa calcular os horários de início e fim de cada etapa, levando em consideração a duração das etapas anteriores e as restrições de horário, como o almoço e o horário máximo para iniciar as atividades de ginástica laboral.

Formatação da saída: A saída deve ser formatada com o horário de cada etapa e o título correspondente. As linhas de montagem devem ser numeradas e separadas por linha vazia. A última etapa do dia deve ser a ginástica laboral.

Portanto, o programa precisa ler o arquivo de entrada, organizar as etapas em linhas de montagem de acordo com as restrições de horário e calcular os horários de início e fim de cada etapa. Em seguida, a saída deve ser formatada corretamente com as informações das linhas de montagem e horários das etapas.


Em seguida, o codigo deve ser revisado para cumprir com melhores padrõesd de boas praticas em sua construção, visando a simplicidade, CleanCode, estrutura do projeto e OO, para que o mesmo se torne mais legível, modular e robusto.

--------------------------------------------------------------------*

Alguns dos desafios encarados durante a construção da aplicação:

Manipulação de datas e horários: Uma das restrições do desafio é não utilizar utilitários ou frameworks para cálculos de datas, como o Joda-Time. Isso significa que a manipulação de datas e horários deve ser feita manualmente, utilizando as classes e métodos disponíveis na linguagem de programação escolhida. Essa manipulação pode ser complexa, especialmente para calcular a duração das etapas e garantir que elas se encaixem dentro dos horários estabelecidos.

Organização das etapas: O desafio requer a organização das etapas em linhas de montagem, seguindo a ordem correta e respeitando as restrições de horário. Foi necessário encontrar uma solução eficiente para essa organização, levando em consideração a duração das etapas, os horários de início e fim e as pausas para almoço e ginástica laboral.

Manutenibilidade e legibilidade do código: Um dos requisitos do desafio é não produzir exatamente a saída de exemplo fornecida, permitindo diferentes combinações e ordens das etapas nas linhas de montagem. Isso implica que o código deve ser estruturado de forma modular e flexível, permitindo fácil manutenção e expansão. Além disso, é essencial que o código seja legível, de modo que outras pessoas possam entender e dar continuidade ao desenvolvimento, se necessário.

Testes e validação: É fundamental realizar testes e validações adequadas para garantir que o programa funcione corretamente em diferentes cenários. Isso inclui testar diferentes arquivos de entrada, considerando diferentes combinações e durações das etapas, além de verificar se os horários estão sendo calculados corretamente e se a formatação da saída está de acordo com as especificações.

--------------------------------------------------------------------*

Como um adicional, deixo aqui, sujestões de continuidade ao projeto como etapas futuras à este desafio, que agregariam funcionalidades que facilitariam a implementação e execução da aplicação. Aumentando a complexidade do desafio:

Interface de usuário: Desenvolver uma interface gráfica ou uma interface de linha de comando interativa para permitir que os usuários selecionem o arquivo de entrada, visualizem os resultados e interajam com a aplicação de forma mais intuitiva.

Validação avançada dos dados de entrada: Implementar uma validação mais robusta dos dados de entrada para garantir que eles estejam corretos e completos. Verifique se todas as etapas têm duração válida, se não há etapas duplicadas ou faltantes e se os horários estão dentro dos limites estabelecidos.

Gestão de recursos: Integrar a gestão de recursos à aplicação. Considerando as restrições adicionais, como a disponibilidade limitada de certos recursos para a realização das etapas do processo de produção. Levando em conta os recursos necessários para cada etapa e garantindo que eles estejam disponíveis nos momentos adequados.

Persistência de dados: Implementar um sistema de persistência de dados para armazenar os dados de entrada, as configurações e os resultados gerados. Isso permitirá que os usuários salvem e carreguem dados, assim como revisitem os resultados anteriores.

Geração de relatórios: Criar a capacidade de gerar relatórios detalhados das linhas de montagem, incluindo a lista de etapas em cada linha, os horários de início e término de cada etapa e o tempo total de produção. Isso facilitará a análise e o monitoramento da produção.

Integração com calendário: Integrar a aplicação com um calendário externo, como o Google Calendar, para agendar automaticamente os horários de início das etapas de produção. Isso permitirá que os usuários tenham uma visão geral dos horários ocupados e evitem conflitos com outros compromissos.

--------------------------------------------------------------------*
