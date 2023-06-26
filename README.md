# Desafio-NeoGrid


Desafio:

Precisamos ajustar nossas linhas de montagem usando as restrições abaixo.
Há tantas possibilidades, você deve escrever um programa para organizar essa produção.

Restrições:

- Não utilize utilitários ou frameworks para cálculos de datas (por exemplo, Joda-Time).
- Utilize o arquivo input.txt como arquivo de dados de entrada do sistema.
- A produção possui várias linhas de montagem e cada uma possui os períodos da manhã, almoço e tarde.
- Cada período possui várias etapas do processo de produção. Obviamente, o período de almoço não as possui.
- O período da manhã começa às 9:00 e deve ser encerrado ao meio-dia, para o almoço.
- O período da tarde começa às 13:00 e deve ser encerrado a tempo das atividades de ginástica laboral.
- As atividades de ginástica laboral podem começar no mínimo às 16:00 e no máximo às 17:00.
- Os títulos das etapas de produção não possuem números.
- Todos os números nos títulos das etapas de produção representam o tempo da etapa em minutos ou a palavra "maintenance", que representa uma pausa técnica de 5 minutos.
- Não haverá intervalo entre as etapas do processo.
- Dependendo de como você escolher resolver esse problema, a saída pode fornecer uma ordem ou combinação diferente das etapas do processo nas linhas de montagem. Isso é aceitável, não há uma ordem necessária para elas e as etapas podem ser distribuídas em qualquer linha de montagem.
- Você não precisa produzir exatamente a saída de exemplo fornecida aqui, mas precisa considerar as restrições!

Diferentes dados de entrada serão usados para testar seu programa, além do exemplo abaixo, e ele pode produzir N linhas de montagem.


Dados de teste (input.txt):

Corte de chapas de aço 60min;
Austenpera (Tratamento térmico) 30min
Temperagem sub-zero (Tratamento térmico) 45min
Montagem do sensor de segurança 60min
Lavagem das peças 45min
Calibração do eixo 30min
Montagem dos rolamentos de aço 45min
Resfriamento da linha de montagem - maintenance
Processo de nitretação 45min
Montagem do subsistema de injeção 60min
Verificação de conformidade 30min
Montagem do subsistema de navegação 60min
Calibração do subsistema do conversor de torque 60min
Alinhamento da barra estabilizadora esquerda 30min
Configuração do dispositivo de bloqueio e controle 45min
Alinhamento da barra estabilizadora direita 30min
Instalação da vedação 45min
Aplicação de decalques 30min
Montagem do subsistema de monitoramento 30min

Exemplo de Saída
Linha de montagem 1:
09:00 Corte de chapas de aço 60min
10:00 Montagem do subsistema de injeção 60min
11:00 Montagem do subsistema de navegação 60min
12:00 Almoço
13:00 Calibração do subsistema do conversor de torque 60min
14:00 Montagem dos rolamentos de aço 45min
14:45 Processo de nitretação 45min
15:30 Configuração do dispositivo de bloqueio e controle 45min
16:15 Verificação de conformidade 30min
16:45 Esfriamento da linha de montagem - maintenance
16:50 Ginástica laboral

Linha de montagem 2:
09:00 Montagem do sensor de segurança 60min
10:00 Temperagem sub-zero (Tratamento térmico) 45min
10:45 Lavagem das peças 45min
11:30 Alinhamento da barra estabilizadora direita 30min
12:00 Almoço
13:00 Instalação da vedação 45min
13:45 Alinhamento da barra estabilizadora esquerda 30min
14:15 Montagem do subsistema de monitoramento 30min
14:45 Aplicação de decalques 30min
15:15 Calibração do eixo 30min
15:45 Austenpera (Tratamento térmico) 30min
16:15 Ginástica laboral
