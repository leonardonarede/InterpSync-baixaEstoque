/*  1:   */ package br.com.interpsync.controller;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.retreadsystem.dao.Vendedores_ERPDAO;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Vendedores_ERP;
/*  5:   */ import br.com.interpsync.saci.dao.Vendedor_SACIDAO;
/*  6:   */ import br.com.interpsync.saci.modelo.Vendedor_SACI;
/*  7:   */ import java.io.PrintStream;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class IntVendedores
/* 13:   */ {
/* 14:   */   public void executar()
/* 15:   */   {
/* 16:   */     try
/* 17:   */     {
/* 18:22 */
    Vendedores_ERPDAO vdpDAO = new Vendedores_ERPDAO();
 Vendedor_SACIDAO vdsDAO = new Vendedor_SACIDAO();
/* 20:24 */       for (Vendedor_SACI vdsaci : vdsDAO.listar()) {
/* 21:25 */         if (vdpDAO.findById(vdsaci.getNo().toString()).getNomeVE() == null)
/* 22:   */         {
/* 23:26 */           Vendedores_ERP vendedorRET = new Vendedores_ERP();
/* 24:27 */           vendedorRET.setCodVE(vdsaci.getNo().toString());
/* 25:28 */           vendedorRET.setNomeVE(vdsaci.getNome());
/* 26:29 */           vendedorRET.setRegiaoVE("IM");
/* 27:30 */           vendedorRET.setStEI(1);
/* 28:31 */           vdpDAO.inserir(vendedorRET);
/* 29:32 */           System.out.println("Vendedor: " + vendedorRET.getNomeVE());
/* 30:   */         }
/* 31:   */       }
/* 32:   */     }
/* 33:   */     catch (SQLException ex)
/* 34:   */     {
/* 35:   */       Vendedores_ERPDAO vdpDAO;
/* 36:36 */       Logger.getLogger(IntVendedores.class.getName()).log(Level.SEVERE, null, ex);
/* 37:   */     }
/* 38:   */     catch (ClassNotFoundException ex)
/* 39:   */     {
/* 40:38 */       Logger.getLogger(IntVendedores.class.getName()).log(Level.SEVERE, null, ex);
/* 41:   */     }
/* 42:   */     catch (Exception ex)
/* 43:   */     {
/* 44:40 */       Logger.getLogger(IntVendedores.class.getName()).log(Level.SEVERE, null, ex);
/* 45:   */     }
/* 46:   */   }
/* 47:   */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.controller.IntVendedores

 * JD-Core Version:    0.7.0.1

 */