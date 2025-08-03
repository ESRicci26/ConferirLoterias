package javaricci.com.br;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ConferirLoterias extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea listaSorteiosTextArea;
    private JTextField jogoTextField;
    private JTextArea resultadoTextArea;
    private JButton conferirButton;
    private JButton limparButton;

    public ConferirLoterias() {
        setTitle("ConferirLoterias - Verificador de Números Sorteados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        initializeComponents();
        setupLayout();
        setupEventListeners();
        
        // Dados de exemplo
        preencherDadosExemplo();
        
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));
    }

    private void initializeComponents() {
        // Área para lista de sorteios
        listaSorteiosTextArea = new JTextArea(15, 50);
        listaSorteiosTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        listaSorteiosTextArea.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Lista de Sorteios (Concurso,Data,Dezenas Sorteadas)"));

        // Campo para jogo a ser conferido
        jogoTextField = new JTextField(30);
        jogoTextField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

        // Área para resultado
        resultadoTextArea = new JTextArea(8, 50);
        resultadoTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        resultadoTextArea.setEditable(false);
        resultadoTextArea.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Resultado da Busca"));
        resultadoTextArea.setBackground(new Color(245, 245, 245));

        // Botões
        conferirButton = new JButton("Conferir Jogo");
        conferirButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        conferirButton.setBackground(new Color(34, 139, 34));
        conferirButton.setForeground(Color.WHITE);

        limparButton = new JButton("Limpar");
        limparButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        limparButton.setBackground(new Color(220, 20, 60));
        limparButton.setForeground(Color.WHITE);
    }

    private void setupLayout() {
        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel superior - Lista de sorteios
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JScrollPane(listaSorteiosTextArea), BorderLayout.CENTER);

        // Panel central - Input do jogo
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Jogo a Conferir"));
        
        JLabel jogoLabel = new JLabel("Digite os números (ex: 24,60,10,12,25,05): ");
        jogoLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        centerPanel.add(jogoLabel);
        centerPanel.add(jogoTextField);

        // Panel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(conferirButton);
        buttonPanel.add(limparButton);

        // Panel inferior - Resultado
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JScrollPane(resultadoTextArea), BorderLayout.CENTER);

        // Adicionar todos os panels
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.add(centerPanel, BorderLayout.NORTH);
        middlePanel.add(buttonPanel, BorderLayout.CENTER);
        middlePanel.add(bottomPanel, BorderLayout.SOUTH);
        
        mainPanel.add(middlePanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void setupEventListeners() {
        conferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conferirJogo();
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        // Permitir conferir com Enter no campo de jogo
        jogoTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conferirJogo();
            }
        });
    }

    private void preencherDadosExemplo() {
        String dadosExemplo = "Concurso,Data,Dezenas Sorteadas\n" +
            "1,11/03/1996,41,05,04,52,30,33\n" +
            "2,18/03/1996,09,39,37,49,43,41\n" +
            "3,25/03/1996,36,30,10,11,29,47\n" +
            "4,01/04/1996,06,59,42,27,01,05\n" +
            "5,08/04/1996,01,19,46,06,16,02\n" +
            "6,15/04/1996,19,40,07,13,22,47\n" +
            "7,22/04/1996,56,38,21,20,03,05\n" +
            "8,29/04/1996,53,17,38,04,47,37\n" +
            "9,06/05/1996,55,43,56,54,08,60\n" +
            "10,13/05/1996,25,04,18,57,21,38\n" +
            "11,20/05/1996,25,15,58,37,59,38\n" +
            "12,27/05/1996,20,27,43,16,19,04\n" +
            "13,03/06/1996,47,32,50,54,18,56\n" +
            "14,10/06/1996,16,02,27,47,23,53\n" +
            "15,17/06/1996,60,12,33,52,35,51\n" +
            "16,24/06/1996,60,58,49,32,20,34\n" +
            "17,01/07/1996,10,20,06,19,51,13\n" +
            "18,08/07/1996,37,36,56,27,42,23\n" +
            "19,15/07/1996,05,25,12,10,60,24\n" +
            "20,22/07/1996,25,28,30,33,51,11";
        
        listaSorteiosTextArea.setText(dadosExemplo);
        jogoTextField.setText("24,60,10,12,25,05");
    }

    private void conferirJogo() {
        try {
            String jogoInput = jogoTextField.getText().trim();
            String listaSorteios = listaSorteiosTextArea.getText().trim();

            if (jogoInput.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, digite os números do jogo!", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (listaSorteios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, insira a lista de sorteios!", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Processar números do jogo
            Set<String> numerosJogo = processarNumerosJogo(jogoInput);
            
            // Buscar na lista de sorteios
            String resultado = buscarJogoNaLista(numerosJogo, listaSorteios);
            
            resultadoTextArea.setText(resultado);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao processar: " + ex.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Set<String> processarNumerosJogo(String jogoInput) {
        Set<String> numeros = new HashSet<>();
        String[] numerosArray = jogoInput.split("[,;\\s]+");
        
        for (String numero : numerosArray) {
            numero = numero.trim();
            if (!numero.isEmpty()) {
                // Garantir formato com dois dígitos
                try {
                    int num = Integer.parseInt(numero);
                    numeros.add(String.format("%02d", num));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Número inválido: " + numero);
                }
            }
        }
        
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("Nenhum número válido encontrado!");
        }
        
        return numeros;
    }

    private String buscarJogoNaLista(Set<String> numerosJogo, String listaSorteios) {
        StringBuilder resultado = new StringBuilder();
        String[] linhas = listaSorteios.split("\n");
        
        boolean encontrou = false;
        int totalLinhas = 0;
        
        resultado.append("=== RESULTADO DA BUSCA ===\n");
        resultado.append("Jogo conferido: ").append(numerosJogo.toString()).append("\n\n");
        
        for (String linha : linhas) {
            linha = linha.trim();
            if (linha.isEmpty() || linha.toLowerCase().contains("concurso")) {
                continue; // Pular cabeçalho e linhas vazias
            }
            
            totalLinhas++;
            
            String[] partes = linha.split(",");
            if (partes.length >= 3) {
                String concurso = partes[0].trim();
                String data = partes[1].trim();
                
                // Extrair números sorteados
                Set<String> numerosSorteados = new HashSet<>();
                for (int i = 2; i < partes.length; i++) {
                    String numero = partes[i].trim();
                    if (!numero.isEmpty()) {
                        try {
                            int num = Integer.parseInt(numero);
                            numerosSorteados.add(String.format("%02d", num));
                        } catch (NumberFormatException e) {
                            // Ignorar números inválidos
                        }
                    }
                }
                
                // Verificar se é uma combinação exata
                if (numerosJogo.equals(numerosSorteados)) {
                    encontrou = true;
                    resultado.append("*** COMBINAÇÃO ENCONTRADA! ***\n");
                    resultado.append("Concurso: ").append(concurso).append("\n");
                    resultado.append("Data: ").append(data).append("\n");
                    resultado.append("Dezenas Sorteadas: ").append(numerosSorteados.toString()).append("\n");
                    resultado.append("Linha original: ").append(linha).append("\n\n");
                }
            }
        }
        
        if (!encontrou) {
            resultado.append("❌ COMBINAÇÃO NÃO ENCONTRADA!\n");
            resultado.append("Esta combinação exata não foi sorteada em nenhum dos ");
            resultado.append(totalLinhas).append(" concursos verificados.\n\n");
            
            // Verificar acertos parciais
            resultado.append("=== ACERTOS PARCIAIS ===\n");
            int acertosEncontrados = verificarAcertosParciais(numerosJogo, listaSorteios, resultado);
            
            if (acertosEncontrados == 0) {
                resultado.append("Nenhum acerto parcial significativo encontrado.\n");
            }
        } else {
            resultado.append("✅ Status: JOGO JÁ FOI SORTEADO!\n");
        }
        
        return resultado.toString();
    }

    private int verificarAcertosParciais(Set<String> numerosJogo, String listaSorteios, StringBuilder resultado) {
        String[] linhas = listaSorteios.split("\n");
        int acertosEncontrados = 0;
        
        for (String linha : linhas) {
            linha = linha.trim();
            if (linha.isEmpty() || linha.toLowerCase().contains("concurso")) {
                continue;
            }
            
            String[] partes = linha.split(",");
            if (partes.length >= 3) {
                String concurso = partes[0].trim();
                String data = partes[1].trim();
                
                Set<String> numerosSorteados = new HashSet<>();
                for (int i = 2; i < partes.length; i++) {
                    String numero = partes[i].trim();
                    if (!numero.isEmpty()) {
                        try {
                            int num = Integer.parseInt(numero);
                            numerosSorteados.add(String.format("%02d", num));
                        } catch (NumberFormatException e) {
                            // Ignorar números inválidos
                        }
                    }
                }
                
                // Calcular acertos
                Set<String> acertos = new HashSet<>(numerosJogo);
                acertos.retainAll(numerosSorteados);
                
                // Mostrar apenas acertos significativos (4 ou mais)
                if (acertos.size() >= 4) {
                    acertosEncontrados++;
                    if (acertosEncontrados <= 5) { // Limitar a 5 resultados
                        resultado.append("Concurso ").append(concurso)
                                .append(" (").append(data).append("): ")
                                .append(acertos.size()).append(" acertos -> ")
                                .append(acertos.toString()).append("\n");
                    }
                }
            }
        }
        
        if (acertosEncontrados > 5) {
            resultado.append("... e mais ").append(acertosEncontrados - 5).append(" concursos com 4+ acertos.\n");
        }
        
        return acertosEncontrados;
    }

    private void limparCampos() {
        jogoTextField.setText("");
        resultadoTextArea.setText("");
        jogoTextField.requestFocus();
    }

    public static void main(String[] args) {
        // Configurar Look and Feel do sistema
        
        // Criar e mostrar a aplicação
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConferirLoterias().setVisible(true);
            }
        });
    }

}