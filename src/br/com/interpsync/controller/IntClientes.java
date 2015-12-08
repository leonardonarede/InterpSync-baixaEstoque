/*  1:   */ package br.com.interpsync.controller;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.retreadsystem.dao.Clientes_ERPDAO;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Clientes_ERP;
/*  5:   */ import br.com.interpsync.saci.dao.Cliente_SACIDAO;
/*  6:   */ import br.com.interpsync.saci.dao.Vendedor_SACIDAO;
/*  7:   */ import br.com.interpsync.saci.modelo.Cliente_SACI;
/*  8:   */ import br.com.interpsync.saci.modelo.Vendedor_SACI;
/*  9:   */ import java.io.PrintStream;
/* 10:   */ import java.math.BigDecimal;
/* 11:   */ import java.sql.SQLException;
/* 12:   */ import java.util.logging.Level;
/* 13:   */ import java.util.logging.Logger;
/* 14:   */ 
/* 15:   */ public class IntClientes
/* 16:   */ {
/* 17:   */   public void executar()
/* 18:   */   {
/* 19:   */     try
/* 20:   */     {
/* 21:25 */
    Clientes_ERPDAO clpdao = new Clientes_ERPDAO();
 Cliente_SACIDAO clsdao = new Cliente_SACIDAO();
/* 23:27 */       for (Cliente_SACI clsaci : clsdao.listar()) {
/* 24:28 */         if (clpdao.findbyid(clsaci.getCpf_cgc().replace(".", "")) == null)
/* 25:   */         {
/* 26:29 */           Clientes_ERP clret = new Clientes_ERP();
/* 27:30 */           clret.setCNPJCPF(clsaci.getCpf_cgc().replace(".", ""));
/* 28:31 */           clret.setNomeCLI(clsaci.getName());
/* 29:32 */           clret.setNrCLI("0");
/* 30:33 */           clret.setEndeCLI(clsaci.getAdd1());
/* 31:34 */           clret.setBairroCLI(clsaci.getNei1());
/* 32:35 */           clret.setCidadeCLI(clsaci.getCity1());
/* 33:36 */           clret.setEstadoCLI(clsaci.getState1());
/* 34:37 */           clret.setCepCLI(clsaci.getZip());
/* 35:38 */           if (clsaci.getFjflag().equals("8"))
/* 36:   */           {
/* 37:39 */             if (clsaci.getBrthplace_insc().isEmpty()) {
/* 38:40 */               clret.setIERGCLI(" ");
/* 39:   */             } else {
/* 40:42 */               clret.setIERGCLI(clsaci.getBrthplace_insc());
/* 41:   */             }
/* 42:44 */             clret.setFJCLI("J");
/* 43:   */           }
/* 44:   */           else
/* 45:   */           {
/* 46:46 */             clret.setIERGCLI("ISENTO");
/* 47:47 */             clret.setFJCLI("F");
/* 48:   */           }
/* 49:49 */           Vendedor_SACI vendedor = new Vendedor_SACI();
/* 50:50 */           Vendedor_SACIDAO vddao = new Vendedor_SACIDAO();
/* 51:51 */           vendedor = vddao.findbyid(Integer.valueOf(Integer.parseInt(clsaci.getSalesperson())));
/* 52:52 */           if ((vendedor == null) || (vendedor.getStoreno() != 3))
/* 53:   */           {
/* 54:53 */             clret.setVendR("1");
/* 55:54 */             clret.setVendP("1");
/* 56:55 */             clret.setVendS("1");
/* 57:   */           }
/* 58:   */           else
/* 59:   */           {
/* 60:57 */             clret.setVendR(clsaci.getSalesperson());
/* 61:58 */             clret.setVendP(clsaci.getSalesperson());
/* 62:59 */             clret.setVendS(clsaci.getSalesperson());
/* 63:   */           }
/* 64:62 */           clret.setPrazoR("AVISTA");
/* 65:63 */           clret.setPrazoP("AVISTA");
/* 66:64 */           clret.setPrazoS("AVISTA");
/* 67:65 */           clret.setComissaoNF(BigDecimal.ZERO);
/* 68:66 */           clret.setComissaoTit(BigDecimal.ZERO);
/* 69:67 */           clret.setRespVencidas(BigDecimal.ZERO);
/* 70:68 */           clret.setRespAVencer(BigDecimal.ZERO);
/* 71:69 */           clret.setCodConceito("1");
/* 72:70 */           clret.setLimiteCrd(clsaci.getCrlimit().toString());
/* 73:71 */           clret.setNContato("0");
/* 74:72 */           clret.setTContato("0");
/* 75:73 */           clret.setStEI(1);
/* 76:74 */           clpdao.inserir(clret);
/* 77:75 */           System.out.println("Cliente: " + clret.getCNPJCPF() + " Nome: " + clret.getNomeCLI());
/* 78:   */         }
/* 79:   */       }
/* 80:   */     }
/* 81:   */     catch (SQLException ex)
/* 82:   */     {
/* 83:   */       Clientes_ERPDAO clpdao;
/* 84:79 */       Logger.getLogger(IntClientes.class.getName()).log(Level.SEVERE, null, ex);
/* 85:   */     }
/* 86:   */     catch (ClassNotFoundException ex)
/* 87:   */     {
/* 88:81 */       Logger.getLogger(IntClientes.class.getName()).log(Level.SEVERE, null, ex);
/* 89:   */     }
/* 90:   */     catch (Exception ex)
/* 91:   */     {
/* 92:83 */       Logger.getLogger(IntClientes.class.getName()).log(Level.SEVERE, null, ex);
/* 93:   */     }
/* 94:   */   }
/* 95:   */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.controller.IntClientes

 * JD-Core Version:    0.7.0.1

 */