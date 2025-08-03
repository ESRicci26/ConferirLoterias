# ConferirLoterias 🎲

Uma aplicação Java Swing para verificar se uma combinação de números já foi sorteada em concursos de loteria anteriores.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Screenshots](#screenshots)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Como Usar](#como-usar)
- [Formato dos Dados](#formato-dos-dados)
- [Exemplos](#exemplos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Contribuindo](#contribuindo)
- [Licença](#licença)
- [Contato](#contato)

## 🎯 Sobre o Projeto

O **ConferirLoterias** é uma ferramenta desktop desenvolvida em Java que permite aos usuários verificar se uma determinada combinação de números já foi sorteada em concursos anteriores de loteria. A aplicação oferece uma interface gráfica intuitiva e recursos avançados de busca e análise.

### Motivação

Muitas pessoas jogam na loteria usando combinações fixas e se perguntam se esses números já foram sorteados anteriormente. Esta aplicação resolve essa questão de forma rápida e eficiente.

## ✨ Funcionalidades

### Principais
- ✅ **Verificação de Combinações Exatas**: Identifica se uma combinação já foi sorteada
- 📊 **Análise de Acertos Parciais**: Mostra concursos com 4 ou mais acertos
- 🔍 **Busca Inteligente**: Normaliza números automaticamente (ex: "5" → "05")
- 📝 **Interface Intuitiva**: Design limpo e fácil de usar
- 🎨 **Dados de Exemplo**: Pré-carregados para teste imediato

### Recursos Técnicos
- 🛡️ **Validação de Entrada**: Trata entradas inválidas graciosamente
- 🔄 **Múltiplos Separadores**: Aceita vírgula, ponto e vírgula ou espaço
- 📋 **Formatação Automática**: Padroniza números para comparação
- ⚡ **Performance Otimizada**: Busca eficiente em grandes listas
- 🎯 **Feedback Detalhado**: Resultados completos e informativos

## 📸 Screenshots

### Tela Principal
```
┌─────────────────────────────────────────────────────────┐
│ ConferirLoterias - Verificador de Números Sorteados    │
├─────────────────────────────────────────────────────────┤
│ Lista de Sorteios (Concurso,Data,Dezenas Sorteadas)    │
│ ┌─────────────────────────────────────────────────────┐ │
│ │ Concurso,Data,Dezenas Sorteadas                     │ │
│ │ 1,11/03/1996,41,05,04,52,30,33                     │ │
│ │ 2,18/03/1996,09,39,37,49,43,41                     │ │
│ │ ...                                                 │ │
│ └─────────────────────────────────────────────────────┘ │
│                                                         │
│ Jogo a Conferir                                         │
│ Digite os números: [24,60,10,12,25,05    ]             │
│                                                         │
│ [Conferir Jogo] [Limpar]                               │
│                                                         │
│ Resultado da Busca                                      │
│ ┌─────────────────────────────────────────────────────┐ │
│ │ *** COMBINAÇÃO ENCONTRADA! ***                      │ │
│ │ Concurso: 19                                        │ │
│ │ Data: 15/07/1996                                    │ │
│ │ Dezenas Sorteadas: [05,10,12,24,25,60]             │ │
│ └─────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────┘
```

## 🔧 Pré-requisitos

Antes de executar a aplicação, certifique-se de ter:

- **Java JDK 8 ou superior** instalado
- **Sistema Operacional**: Windows, macOS ou Linux com suporte a GUI
- **Memória RAM**: Mínimo 512MB disponível

### Verificar Instalação do Java

```bash
java -version
javac -version
```

## 🚀 Instalação

### Opção 1: Download Direto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/conferir-loterias.git
   cd conferir-loterias
   ```

2. **Compile o código**
   ```bash
   javac ConferirLoterias.java
   ```

3. **Execute a aplicação**
   ```bash
   java ConferirLoterias
   ```

### Opção 2: JAR Executável

1. **Compile para JAR**
   ```bash
   javac ConferirLoterias.java
   jar cfe ConferirLoterias.jar ConferirLoterias *.class
   ```

2. **Execute o JAR**
   ```bash
   java -jar ConferirLoterias.jar
   ```

### Opção 3: Script de Build

Crie um arquivo `build.sh` (Linux/macOS) ou `build.bat` (Windows):

**Linux/macOS (build.sh):**
```bash
#!/bin/bash
echo "Compilando ConferirLoterias..."
javac ConferirLoterias.java
if [ $? -eq 0 ]; then
    echo "Compilação bem-sucedida!"
    echo "Executando aplicação..."
    java ConferirLoterias
else
    echo "Erro na compilação!"
fi
```

**Windows (build.bat):**
```batch
@echo off
echo Compilando ConferirLoterias...
javac ConferirLoterias.java
if %errorlevel% == 0 (
    echo Compilacao bem-sucedida!
    echo Executando aplicacao...
    java ConferirLoterias
) else (
    echo Erro na compilacao!
)
```

## 📖 Como Usar

### 1. Iniciando a Aplicação

Ao executar a aplicação, você verá três áreas principais:

- **Lista de Sorteios** (superior): Para inserir dados históricos
- **Jogo a Conferir** (meio): Para inserir a combinação a ser verificada
- **Resultado da Busca** (inferior): Mostra os resultados encontrados

### 2. Inserindo Dados de Sorteios

Na área "Lista de Sorteios", insira os dados no formato:
```
Concurso,Data,Dezenas Sorteadas
1,11/03/1996,41,05,04,52,30,33
2,18/03/1996,09,39,37,49,43,41
```

**Observações importantes:**
- A primeira linha (cabeçalho) é opcional
- Use vírgulas para separar campos
- A ordem dos números nas dezenas não importa
- Números podem ter 1 ou 2 dígitos (serão normalizados)

### 3. Conferindo um Jogo

1. **Digite os números** no campo "Jogo a Conferir"
   ```
   24,60,10,12,25,05
   ```

2. **Clique em "Conferir Jogo"** ou pressione **Enter**

3. **Veja o resultado** na área inferior

### 4. Interpretando Resultados

#### Combinação Encontrada ✅
```
*** COMBINAÇÃO ENCONTRADA! ***
Concurso: 19
Data: 15/07/1996
Dezenas Sorteadas: [05,10,12,24,25,60]
✅ Status: JOGO JÁ FOI SORTEADO!
```

#### Combinação Não Encontrada ❌
```
❌ COMBINAÇÃO NÃO ENCONTRADA!
Esta combinação exata não foi sorteada em nenhum dos 20 concursos verificados.

=== ACERTOS PARCIAIS ===
Concurso 15 (17/06/1996): 4 acertos -> [12,33,52,60]
Concurso 10 (13/05/1996): 4 acertos -> [04,18,25,57]
```

## 📊 Formato dos Dados

### Estrutura CSV

```csv
Concurso,Data,Dezena1,Dezena2,Dezena3,Dezena4,Dezena5,Dezena6
1,11/03/1996,41,05,04,52,30,33
2,18/03/1996,09,39,37,49,43,41
```

### Formatos Aceitos

| Campo | Formato | Exemplo | Observações |
|-------|---------|---------|-------------|
| Concurso | Número inteiro | `1`, `100`, `2745` | Identificador único |
| Data | DD/MM/AAAA | `15/07/1996` | Formato brasileiro |
| Dezenas | Números separados por vírgula | `05,10,12,24,25,60` | 1-2 dígitos cada |

### Separadores Suportados

- **Vírgula**: `1,2,3,4,5,6`
- **Ponto e vírgula**: `1;2;3;4;5;6`
- **Espaço**: `1 2 3 4 5 6`
- **Misto**: `1, 2; 3 4,5 6`

## 🎯 Exemplos

### Exemplo 1: Jogo Encontrado

**Entrada:**
```
Jogo: 24,60,10,12,25,05
```

**Resultado:**
```
=== RESULTADO DA BUSCA ===
Jogo conferido: [05,10,12,24,25,60]

*** COMBINAÇÃO ENCONTRADA! ***
Concurso: 19
Data: 15/07/1996
Dezenas Sorteadas: [05,10,12,24,25,60]
Linha original: 19,15/07/1996,05,25,12,10,60,24
✅ Status: JOGO JÁ FOI SORTEADO!
```

### Exemplo 2: Jogo Não Encontrado com Acertos Parciais

**Entrada:**
```
Jogo: 01,02,03,04,05,06
```

**Resultado:**
```
=== RESULTADO DA BUSCA ===
Jogo conferido: [01,02,03,04,05,06]

❌ COMBINAÇÃO NÃO ENCONTRADA!
Esta combinação exata não foi sorteada em nenhum dos 20 concursos verificados.

=== ACERTOS PARCIAIS ===
Concurso 4 (01/04/1996): 4 acertos -> [01,05,06,27]
Concurso 5 (08/04/1996): 4 acertos -> [01,02,06,16]
```

### Exemplo 3: Formatos de Entrada Diferentes

Todas essas entradas são equivalentes:
```
24,60,10,12,25,05
24; 60; 10; 12; 25; 05
24 60 10 12 25 05
24,60,10,12,25,5
```

## 🏗️ Estrutura do Projeto

```
conferir-loterias/
│
├── ConferirLoterias.java      # Classe principal da aplicação
├── README.md                  # Este arquivo
├── LICENSE                    # Licença do projeto
├── build.sh                   # Script de build para Linux/macOS
├── build.bat                  # Script de build para Windows
│
├── docs/                      # Documentação adicional
│   ├── manual-usuario.md      # Manual detalhado do usuário
│   ├── arquitetura.md         # Documentação da arquitetura
│   └── changelog.md           # Histórico de versões
│
├── examples/                  # Exemplos de uso
│   ├── mega-sena.csv         # Dados da Mega-Sena
│   ├── quina.csv             # Dados da Quina
│   └── lotofacil.csv         # Dados da Lotofácil
│
└── tests/                     # Testes (futuro)
    ├── TestConferirLoterias.java
    └── dados-teste.csv
```

### Arquitetura da Aplicação

```
ConferirLoterias
├── Interface Gráfica (Swing)
│   ├── JTextArea (Lista de Sorteios)
│   ├── JTextField (Jogo a Conferir)
│   ├── JTextArea (Resultado)
│   └── JButtons (Ações)
│
├── Lógica de Negócio
│   ├── processarNumerosJogo()
│   ├── buscarJogoNaLista()
│   └── verificarAcertosParciais()
│
└── Utilitários
    ├── Validação de entrada
    ├── Normalização de números
    └── Formatação de resultados
```

## 🔧 Funcionalidades Técnicas

### Algoritmo de Busca

1. **Normalização**: Converte números para formato padronizado (2 dígitos)
2. **Comparação**: Usa `Set` para comparação exata de combinações
3. **Acertos Parciais**: Calcula interseção entre conjuntos
4. **Performance**: Complexidade O(n*m) onde n=concursos, m=números por jogo

### Tratamento de Erros

- **Números Inválidos**: Ignora entradas não numéricas
- **Formatos Incorretos**: Trata linhas malformadas
- **Campos Vazios**: Valida entrada antes do processamento
- **Exceções**: Captura e exibe erros de forma amigável

### Validações Implementadas

| Validação | Descrição | Ação |
|-----------|-----------|------|
| Campo vazio | Jogo não informado | Exibe aviso |
| Lista vazia | Sorteios não informados | Exibe aviso |
| Números inválidos | Caracteres não numéricos | Ignora entrada |
| Formato incorreto | Linha malformada | Pula linha |

## 🤝 Contribuindo

Contribuições são muito bem-vindas! Siga estes passos:

### 1. Fork do Projeto

```bash
git clone https://github.com/seu-usuario/conferir-loterias.git
```

### 2. Crie uma Branch

```bash
git checkout -b feature/nova-funcionalidade
```

### 3. Faça suas Alterações

- Mantenha o padrão de código existente
- Adicione comentários explicativos
- Teste suas alterações

### 4. Commit das Alterações

```bash
git add .
git commit -m "feat: adiciona nova funcionalidade X"
```

### 5. Push para a Branch

```bash
git push origin feature/nova-funcionalidade
```

### 6. Abra um Pull Request

Descreva suas alterações e aguarde a revisão.

### Diretrizes de Contribuição

- **Código**: Siga as convenções Java padrão
- **Commits**: Use mensagens descritivas
- **Testes**: Adicione testes para novas funcionalidades
- **Documentação**: Atualize a documentação quando necessário

### Roadmap

- [ ] **v2.0**: Suporte a múltiplas modalidades de loteria
- [ ] **v2.1**: Importação de arquivos CSV/TXT
- [ ] **v2.2**: Exportação de resultados
- [ ] **v2.3**: Estatísticas avançadas
- [ ] **v3.0**: Interface web
- [ ] **v3.1**: API REST
- [ ] **v3.2**: Banco de dados

## 📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

### MIT License

## 📞 Contato

- **Desenvolvedor**: EDILSON SALVADOR RICCI
- **Email**: esricci26@gmail.com
- **GitHub**: (https://github.com/ESRICCI26)

### Suporte

Para suporte e dúvidas:

1. **Issues do GitHub**: [Criar issue](https://github.com/seu-usuario/conferir-loterias/issues)
2. **Discussões**: [GitHub Discussions](https://github.com/seu-usuario/conferir-loterias/discussions)

---

## 🙏 Agradecimentos

- Comunidade Java pela excelente documentação
- Usuários que testaram e deram feedback
- Contribuidores do projeto

---

<div align="center">

**⭐ Se este projeto foi útil para você, deixe uma estrela! ⭐**

Feito com ❤️ em Java

</div>
