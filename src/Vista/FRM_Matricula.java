/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_Matricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tecnologiamultimedia
 */
public class FRM_Matricula extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Matricula
     */
    DefaultTableModel modelo;
    
    public Controlador_FRM_Matricula controlador;
    
    public FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos) {
        initComponents();
        controlador=new Controlador_FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos,this);
        modelo=new DefaultTableModel();
        this.tbl_Matricula.setModel(modelo);
        colocarTitulosTabla();
        gUI_Botones2.agregarEventos(controlador);
        agregarEvento();
        estadoInicial();
    }
     public void establecerFuente(String eleccion){
        controlador.establecerFuente(eleccion);
    }
    public String devolverCodigo()
    {
        return this.jt_CodigoMatricula.getText();
    }
    public String devolverCedula()
    {
        return this.jt_Cedula.getText();
    }
    
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    
    public void mostrarNombreEstudiante(String nombre)
    {
        this.jt_NombreEstudiante.setText(nombre);
    } 
    
    public void mostrarInformacion(String arreglo[]){
        this.jt_Cedula.setText(arreglo[1]);
        this.jt_Sigla.setText(arreglo[0]);
    }
    
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void mostrarNombreCurso(String nombre)
    {
        this.jt_NombreCurso.setText(nombre);
    } 
    
    public void agregarEventos()
    {
        this.btn_ConsultaRapidaEstudiante.addActionListener(controlador);
        this.btn_ConsultaRapidaSigla.addActionListener(controlador);
        this.gUI_Botones2.agregarEventos(controlador);
    }
    
    public void cargarTabla()
    {
        String arreglo[]=new String[4];
        arreglo[0]=this.jt_Cedula.getText();
        arreglo[1]=this.jt_NombreEstudiante.getText();
        arreglo[2]=this.jt_Sigla.getText();
        arreglo[3]=this.jt_NombreCurso.getText();
        
        modelo.addRow(arreglo);
        this.tbl_Matricula.setModel(modelo);
    }
    
     public String[] devolverInformacion()
    {
        String arreglo[];
        arreglo=new String[3];
        arreglo[0]=this.jt_CodigoMatricula.getText();
        arreglo[1]=this.jt_Cedula.getText();
        arreglo[2]=this.jt_Sigla.getText();
        
        return arreglo;
    }
    
    public void eliminarFila()
    {
        int filaSeleccionada=tbl_Matricula.getSelectedRow();
        if(filaSeleccionada>=0)
        {
            modelo.removeRow(filaSeleccionada);
        }else
        {
            JOptionPane.showMessageDialog(null,"Seleccione la fila a eliminar");
        }
    }
    
    public void colocarTitulosTabla()
    {
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre Estudiante");
        modelo.addColumn("Sigla");
        modelo.addColumn("Nombre Curso");
    }
    
    public void colocarCodigo()
    {
        this.jt_CodigoMatricula.setText(controlador.colocarCodigo());
    }
    
    public String[] getInformacionTabla(int contador)
    {
        String arreglo[]=new String[3];
        arreglo[0]=this.jt_CodigoMatricula.getText();
        arreglo[1]=""+this.modelo.getValueAt(contador, 0);
        arreglo[2]=""+this.modelo.getValueAt(contador, 2);
        
        return arreglo;
    }
    
    
    public void limpiarCurso()
    {
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
        
    }
  public void resetearInterfaz()
    {
        colocarCodigo();
        this.jt_Cedula.setText("");
        this.jt_NombreCurso.setText("");
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
        
        int tamanio=modelo.getRowCount();
        
        for(int contador=0;contador<tamanio;contador++)
        {
            modelo.removeRow(0);
        }
    }
    
    public int getCantidadDeCursosMatriculados()
    {
        return modelo.getRowCount();
    }
    
    public void estadoInicial()
    {
      this.gUI_Botones2.estadoInicial();
      this.jt_Sigla.setEnabled(false);
      this.jt_Cedula.setEnabled(false);
      this.jt_NombreCurso.setEnabled(false);
      this.jt_NombreEstudiante.setEnabled(false);
      this.btn_Finalizar.setEnabled(false);
      this.jt_CodigoMatricula.setEnabled(true);
    }
    public void habilitarOpciones()
    {
      this.gUI_Botones2.habilitarOpciones();
      this.jt_Sigla.setEnabled(false);
      this.jt_Cedula.setEnabled(false);
      this.jt_NombreCurso.setEnabled(false);
      this.jt_NombreEstudiante.setEnabled(false);
      this.btn_Finalizar.setEnabled(false);   
    }
    
    public void habilitarAgregar()
    {
      gUI_Botones2.habilitarAgregar();
      this.btn_Finalizar.setEnabled(true);
      this.jt_Sigla.setEnabled(true);
      this.jt_Cedula.setEnabled(true);
      this.jt_NombreCurso.setEnabled(true);
      this.jt_NombreEstudiante.setEnabled(true);
      this.jt_CodigoMatricula.setEnabled(false);
      
    }
    
    public void agregarEvento(){
        this.btn_Finalizar.addActionListener(controlador);
        this.btn_ConsultaRapidaEstudiante.addActionListener(controlador);
        this.btn_ConsultaRapidaSigla.addActionListener(controlador);
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jl_NombreEstudiante = new javax.swing.JLabel();
        jl_Sigla = new javax.swing.JLabel();
        jl_NombreCurso = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_NombreEstudiante = new javax.swing.JTextField();
        jt_Sigla = new javax.swing.JTextField();
        jt_NombreCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Matricula = new javax.swing.JTable();
        gUI_Botones2 = new Vista.GUI_Botones();
        btn_ConsultaRapidaSigla = new javax.swing.JButton();
        btn_ConsultaRapidaEstudiante = new javax.swing.JButton();
        jl_CodigoMatricula = new javax.swing.JLabel();
        jt_CodigoMatricula = new javax.swing.JTextField();
        btn_Finalizar = new javax.swing.JButton();

        jl_Cedula.setText("Cédula");

        jl_NombreEstudiante.setText("Nombre");

        jl_Sigla.setText("Sigla");

        jl_NombreCurso.setText("Nombre");

        jt_NombreCurso.setEditable(false);

        tbl_Matricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Matricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_MatriculaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Matricula);

        btn_ConsultaRapidaSigla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapidaSigla.setActionCommand("ConsultaRapidaCurso");

        btn_ConsultaRapidaEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapidaEstudiante.setActionCommand("ConsultaRapidaEstudiante");

        jl_CodigoMatricula.setText("Código");

        btn_Finalizar.setText("Finalizar Matricula");
        btn_Finalizar.setActionCommand("Finalizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_NombreEstudiante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jt_NombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jl_CodigoMatricula)
                                    .addGap(18, 18, 18)
                                    .addComponent(jt_CodigoMatricula))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jl_Cedula)
                                    .addGap(18, 18, 18)
                                    .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_ConsultaRapidaEstudiante))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Sigla, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_NombreCurso, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_ConsultaRapidaSigla))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(gUI_Botones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Finalizar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_CodigoMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_Sigla)
                                    .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_ConsultaRapidaSigla)
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreCurso)
                            .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jl_Cedula)
                                .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_ConsultaRapidaEstudiante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreEstudiante)
                            .addComponent(jt_NombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gUI_Botones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btn_Finalizar)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_MatriculaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MatriculaMousePressed
        System.out.println("Hola");
    }//GEN-LAST:event_tbl_MatriculaMousePressed
    
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaRapidaEstudiante;
    private javax.swing.JButton btn_ConsultaRapidaSigla;
    private javax.swing.JButton btn_Finalizar;
    private Vista.GUI_Botones gUI_Botones2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_CodigoMatricula;
    private javax.swing.JLabel jl_NombreCurso;
    private javax.swing.JLabel jl_NombreEstudiante;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_NombreEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private javax.swing.JTable tbl_Matricula;
    // End of variables declaration//GEN-END:variables
}
