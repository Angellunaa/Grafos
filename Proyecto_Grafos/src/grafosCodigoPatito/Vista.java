package grafosCodigoPatito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Vista extends javax.swing.JFrame
{
    private static String nombreN[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
    "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};//Nombre de los nodos
    private static boolean NodoActivo = false;//Indica se el boton Nodo esta activo
    private static boolean AristaActivo = false;//Indica si el boton arista esta activo
    private static boolean EsPesada = false;
    private static ArrayList<Nodo> ListaNodos;//Lista con los vertices
    private static ArrayList<Arista> ListaAristas;//Lista con las aristas
    private static final int maxN = nombreN.length; //Maximo numero de nodos
    private static final int maxL = Arista.getNombreL().length; //Maximo numero de aristas
    private static boolean MAdyacencia[][] = new boolean[maxN][maxN];//Matriz de adyacencia sin peso
    private static boolean MIncidencia[][] = new boolean[maxN][maxL];//Matriz de incidencia sin peso
    private static int MAdyPesada[][] = new int[maxN][maxN];
    private String TextoMAdyacente = "", TextoMIncidencia = ""; //Texto con la matriz de adyacencia e incidencia
    private static int ContN = 0;//Contador del numero de nodos usados
    private static int ContL = 0;//Contador del numero de aristas usados
    private Point vertice1, vertice2;
    private int x,y;

    public Vista() {
        initComponents();
        ListaNodos = new ArrayList<>();
        ListaAristas = new ArrayList<>();
        setTitle("Grafos");
        setLocationRelativeTo(null);
        setResizable(false);
        JFEditarArista.pack();
        
        //Se inicializan las matrices
        for (int r = 0; r < maxN; r++) {
            for (int s = 0; s < maxN; s++) {
                MAdyacencia[r][s] = false;
            }
        }
        for (int r = 0; r < maxN; r++) {
            for (int s = 0; s < maxN; s++) {
                MAdyPesada[r][s] = 0;
            }
        }
        for (int e = 0; e < maxN; e++) {
            for (int f = 0; f < maxL; f++) {
                MIncidencia[e][f] = false;
            }
        }
        
        LBMatriz.setEditable(false);
        btnLinea.setEnabled(false);
        btnAyacente.setEnabled(false);
        btnIncidencia.setEnabled(false);
    }

    public static boolean isNodoActivo() { return NodoActivo; }

    public static void setNodoActivo(boolean NodoActivo) { Vista.NodoActivo = NodoActivo; }

    public static boolean isAristaActivo() {  return AristaActivo; }

    public static void setAristaActivo(boolean AristaActivo) { Vista.AristaActivo = AristaActivo; }

    public static ArrayList<Nodo> getListaNodos() { return ListaNodos; }

    public static void setListaNodos(ArrayList<Nodo> ListaNodos) { Vista.ListaNodos = ListaNodos; }

    public static ArrayList<Arista> getListaAristas() { return ListaAristas; }

    public static void setListaAristas(ArrayList<Arista> ListaAristas) { Vista.ListaAristas = ListaAristas; }

    public static int getMaxN() { return maxN; }

    public static int getMaxL() { return maxL; }

    public static boolean[][] getMAdyacencia() { return MAdyacencia; }

    public static void setMAdyacencia(boolean[][] MAdyacencia) { Vista.MAdyacencia = MAdyacencia; }

    public static boolean[][] getMIncidencia() { return MIncidencia; }

    public static void setMIncidencia(boolean[][] MIncidencia) { Vista.MIncidencia = MIncidencia; }

    public static int getContL() { return ContL; }

    public static void setContL(int ContL) { Vista.ContL = ContL; }

    public static int getContN() { return ContN; }

    public static void setContN(int ContN) { Vista.ContN = ContN; }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFEditarArista = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFPeso = new javax.swing.JTextField();
        BTSDireccion = new javax.swing.JButton();
        BTCDireccion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAyacente = new javax.swing.JButton();
        btnIncidencia = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnVertice = new javax.swing.JButton();
        btnLinea = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LBMatriz = new javax.swing.JTextArea();
        PanelGrafo = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Algoritmos = new javax.swing.JMenu();
        JMenu_Bipartito = new javax.swing.JMenu();
        MIEmparejamientoAngel = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        JFEditarArista.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editar peso");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agregar Arista");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TFPeso.setBackground(new java.awt.Color(255, 255, 255));
        TFPeso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TFPeso.setForeground(new java.awt.Color(0, 0, 0));
        TFPeso.setText("1");

        BTSDireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BTSDireccion.setText("Sin diección");
        BTSDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSDireccionActionPerformed(evt);
            }
        });

        BTCDireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BTCDireccion.setText("Con dirección");
        BTCDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCDireccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JFEditarAristaLayout = new javax.swing.GroupLayout(JFEditarArista.getContentPane());
        JFEditarArista.getContentPane().setLayout(JFEditarAristaLayout);
        JFEditarAristaLayout.setHorizontalGroup(
            JFEditarAristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFEditarAristaLayout.createSequentialGroup()
                .addGroup(JFEditarAristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JFEditarAristaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JFEditarAristaLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BTSDireccion)
                        .addGap(29, 29, 29)
                        .addComponent(BTCDireccion)))
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(JFEditarAristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JFEditarAristaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        JFEditarAristaLayout.setVerticalGroup(
            JFEditarAristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFEditarAristaLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(JFEditarAristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(JFEditarAristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTSDireccion)
                    .addComponent(BTCDireccion))
                .addContainerGap())
            .addGroup(JFEditarAristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JFEditarAristaLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        btnAyacente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/matriz.png"))); // NOI18N
        btnAyacente.setText("Adyacencia");
        btnAyacente.setFocusPainted(false);
        btnAyacente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAyacente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAyacente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyacenteActionPerformed(evt);
            }
        });

        btnIncidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/matriz.png"))); // NOI18N
        btnIncidencia.setText("Incidencia");
        btnIncidencia.setFocusPainted(false);
        btnIncidencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIncidencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncidenciaActionPerformed(evt);
            }
        });

        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        btnVertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circulo.png"))); // NOI18N
        btnVertice.setText("Vertice");
        btnVertice.setToolTipText("");
        btnVertice.setFocusPainted(false);
        btnVertice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVertice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerticeActionPerformed(evt);
            }
        });

        btnLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea.png"))); // NOI18N
        btnLinea.setText("Arista");
        btnLinea.setFocusPainted(false);
        btnLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAyacente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIncidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAyacente, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(btnVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir1)
                .addContainerGap())
        );

        LBMatriz.setColumns(20);
        LBMatriz.setRows(5);
        LBMatriz.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matrizes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 12))); // NOI18N
        jScrollPane1.setViewportView(LBMatriz);

        PanelGrafo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        PanelGrafo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelGrafoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelGrafoLayout = new javax.swing.GroupLayout(PanelGrafo);
        PanelGrafo.setLayout(PanelGrafoLayout);
        PanelGrafoLayout.setHorizontalGroup(
            PanelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        PanelGrafoLayout.setVerticalGroup(
            PanelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        Algoritmos.setText("Algoritmos");

        JMenu_Bipartito.setText("Bipartito");

        MIEmparejamientoAngel.setText("EmparejamientoAngel");
        MIEmparejamientoAngel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIEmparejamientoAngelActionPerformed(evt);
            }
        });
        JMenu_Bipartito.add(MIEmparejamientoAngel);

        Algoritmos.add(JMenu_Bipartito);

        jMenu2.setText("Emparejamiento");

        jMenuItem2.setText("Tonto");
        jMenu2.add(jMenuItem2);

        jMenuItem1.setText("Edmons I");
        jMenu2.add(jMenuItem1);

        Algoritmos.add(jMenu2);

        jMenuBar1.add(Algoritmos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerticeActionPerformed
        if (NodoActivo)
        {
            NodoActivo = false;
            AristaActivo = false;
            lblEstado.setText("Vertice y Arista Desactivado");
            btnVertice.setBackground(null);
            btnLinea.setBackground(null);
        }
        else
        {
            AristaActivo = false;
            NodoActivo = true;
            btnVertice.setBackground(Color.decode("#79f966"));
            btnLinea.setBackground(null);
            lblEstado.setText("Vertice Activo");
        }
    }//GEN-LAST:event_btnVerticeActionPerformed

    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        if (AristaActivo)
        {
            AristaActivo = false;
            NodoActivo = false;
            lblEstado.setText("Vertice y Arista Desactivado");
            btnVertice.setBackground(null);
            btnLinea.setBackground(null);
        }
        else
        {
            NodoActivo = false;
            vertice1 = null;
            AristaActivo = true;
            btnLinea.setBackground(Color.decode("#79f966"));
            btnVertice.setBackground(null);
            lblEstado.setText("Arista Activo");
        }
    }//GEN-LAST:event_btnLineaActionPerformed
    
    public void muestraAdyacencia()
    {
        TextoMAdyacente = "Matriz de Adyacencia  \n\n";
        TextoMAdyacente += "     ";
        for (Nodo nodos : ListaNodos)//Imprime nombre de los nodos
        {
            TextoMAdyacente += "  " + nodos.Nombre;
        }
        for (Nodo nodosx : ListaNodos)
        {
            TextoMAdyacente += "\n" + nodosx.Nombre+"     ";
            for (Nodo nodosy : ListaNodos)
            {
                if(MAdyacencia[ListaNodos.indexOf(nodosx)][ListaNodos.indexOf(nodosy)])
                {
                    TextoMAdyacente += 1+"  ";
                }
                else
                {
                    TextoMAdyacente += 0+"  ";
                }
            }
        }
        setMatriz(TextoMAdyacente, TextoMIncidencia);
    }
    
    private void btnAyacenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyacenteActionPerformed
        muestraAdyacencia();
    }//GEN-LAST:event_btnAyacenteActionPerformed

    public void muestraIncidencia()
    {
        TextoMIncidencia = "Matriz de Incidencia  \n\n";
        int tNodos = ListaNodos.size();
        int bit = 0;
        String Nom = "";
        TextoMIncidencia += "  ";
        TextoMIncidencia += "  ";
        for (int k = 0; k < tNodos; k++)
        {
            TextoMIncidencia += "   " + nombreN[k];
        }
        for (int k = 0; k < tNodos; k++)
        {
            TextoMIncidencia += "   \n";
            for (int l = 0; l < tNodos; l++)
            {
                if (MIncidencia[k][l])
                {
                    bit = 0;
                }
                else
                {
                    bit = 1;
                }
                if (l == 0)
                {
                    Nom = Arista.getNombreL()[k] + "  ";
                }
                else
                {
                    Nom = "";
                }
                TextoMIncidencia += Nom + bit + "   ";
            }
        }
        setMatriz(TextoMIncidencia, TextoMAdyacente);
    }
    
    private void btnIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncidenciaActionPerformed
        muestraIncidencia();
    }//GEN-LAST:event_btnIncidenciaActionPerformed

    //Imprime la matriz de adyacencia e incidencia
    public void setMatriz(String matriz1, String matriz2) {
        LBMatriz.setText(matriz1 + "\n\n" + matriz2);
    }
    
    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    //Se activa al hacer click en el panel del grafo. Dibuja un nuevo vertice
    private void PanelGrafoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelGrafoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1)
        {
            if (Vista.isNodoActivo())//Si el boton nodo esta activo. Crear un nuevo nodo
            {    
                if(ListaNodos.isEmpty())
                {
                    MIEmparejamientoAngel.setEnabled(true);
                    btnAyacente.setEnabled(true);
                    btnIncidencia.setEnabled(true);
                    btnLinea.setEnabled(true);
                }

                ListaNodos.add(new Nodo(evt.getX(),evt.getY(),nombreN[ContN]));
                pintar(PanelGrafo.getGraphics());
                ContN++;
                
                if(nombreN.length == ContN)
                {
                    btnVertice.setEnabled(false);
                }   
            }
            if(Vista.isAristaActivo())
            {
                for(Nodo nodos : ListaNodos)
                {
                    if(new Rectangle(nodos.getX() - Nodo.d/2, nodos.getY() - Nodo.d/2, Nodo.d, Nodo.d).contains(evt.getPoint()))
                    {
                        if(vertice1 == null)
                        {
                            vertice1 = new Point(nodos.getX(), nodos.getY());
                            x = ListaNodos.indexOf(nodos);
                            nodos.pintar(PanelGrafo.getGraphics(), Color.GREEN);
                        }
                        else //Se hace el enlace
                        {
                            vertice2 = new Point(nodos.getX(), nodos.getY());
                            y = ListaNodos.indexOf(nodos);
                            JFEditarArista.setVisible(true);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_PanelGrafoMouseClicked

    private void BTSDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSDireccionActionPerformed
        try
        {
            int peso;
            if ((peso = Integer.valueOf(TFPeso.getText())) > 0) {
                MAdyPesada[x][y] = peso;
                MAdyPesada[y][x] = peso;
            } else {
                MAdyPesada[x][y] = 1;
                MAdyPesada[y][x] = 1;
            }
            MAdyacencia[x][y] = true;
            MAdyacencia[y][x] = true;
            MIncidencia[x][y] = true;
            MIncidencia[y][x] = true;
            ListaAristas.add(new Arista(vertice1, vertice2, false, peso));
            vertice1 = null;
            vertice2 = null;
            ContL++;
            pintar(PanelGrafo.getGraphics());
            JFEditarArista.setVisible(false);
        }
        catch(java.lang.NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(JFEditarArista, "Numero de no válido", "Mensaje de Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BTSDireccionActionPerformed

    private void BTCDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCDireccionActionPerformed
        try
        {
            int peso;
            if((peso = Integer.valueOf(TFPeso.getText())) > 0)
            {
                MAdyPesada[x][y] = peso;
            }
            else
            {
                MAdyPesada[x][y] = 1;
            }
            MAdyacencia[x][y] = true;
            MIncidencia[x][y] = true;
            ListaAristas.add(new Arista(vertice1, vertice2, true, peso));
            vertice1 = null;
            vertice2 = null;
            ContL++;
            pintar(PanelGrafo.getGraphics());
            MIEmparejamientoAngel.setEnabled(false);
            JFEditarArista.setVisible(false);
        }
        catch(java.lang.NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(JFEditarArista, "Numero de no válido", "Mensaje de Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BTCDireccionActionPerformed

    private void MIEmparejamientoAngelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIEmparejamientoAngelActionPerformed
        Forma1_Bipartito.BipartitoAngel();
    }//GEN-LAST:event_MIEmparejamientoAngelActionPerformed
    
    private void pintar(Graphics g)
    {
        for(Arista aristas : Vista.getListaAristas())
        {
            aristas.pintar(g,Color.BLACK);
        }
        for(Nodo nodos : Vista.getListaNodos())
        {
            nodos.pintar(g, Color.CYAN);
        }
    }
    
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Algoritmos;
    private javax.swing.JButton BTCDireccion;
    private javax.swing.JButton BTSDireccion;
    private javax.swing.JFrame JFEditarArista;
    private javax.swing.JMenu JMenu_Bipartito;
    private javax.swing.JTextArea LBMatriz;
    private javax.swing.JMenuItem MIEmparejamientoAngel;
    public static javax.swing.JPanel PanelGrafo;
    private javax.swing.JTextField TFPeso;
    private javax.swing.JButton btnAyacente;
    private javax.swing.JButton btnIncidencia;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnVertice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
