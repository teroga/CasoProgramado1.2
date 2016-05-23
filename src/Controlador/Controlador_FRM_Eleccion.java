/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.FRM_Eleccion;
import Vista.FRM_Login;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Stephannie
 */
public class Controlador_FRM_Eleccion implements ActionListener {
    
    FRM_MenuPrincipal frm_menuPrincipal;
    FRM_Login login;
    FRM_Eleccion frm_eleccion;
    
    public Controlador_FRM_Eleccion(FRM_Eleccion frm_eleccion, FRM_MenuPrincipal frm_MenuPrincipal){
        this.frm_eleccion=frm_eleccion;
        this.frm_menuPrincipal=frm_MenuPrincipal;
       login=new FRM_Login(frm_MenuPrincipal);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Confirmar")){
            System.out.println("Confirmar");
           login.setVisible(true);
                    if( frm_eleccion.devolverEleccionArchivos()){
                        System.out.println("Entró a Archivos");
                       frm_menuPrincipal.controlador_FRM_MenuPrincipal.establecerFuente("Archivos");
                    }
                     if(frm_eleccion.devolverEleccionBD()){
                         System.out.println("Entró a BD");
                         frm_menuPrincipal.controlador_FRM_MenuPrincipal.establecerFuente("BD");
                     }
                     if(frm_eleccion.devolverEleccionXML()){
                        System.out.println("Entró a XML");
                        frm_menuPrincipal.controlador_FRM_MenuPrincipal.establecerFuente("XML");
                     }
                     
                     frm_eleccion.setVisible(false);
            }
        
        }
    }//Fin
    