/*   1:    */ package br.com.interpsync.controller;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.interdb.dao.Coxins_INTERDBDAO;
/*   4:    */ import br.com.interpsync.interdb.dao.Desreforma_INTERDBDAO;
/*   5:    */ import br.com.interpsync.interdb.dao.Osvr_INTERDBDAO;
/*   6:    */ import br.com.interpsync.retreadsystem.modelo.Coxins_ERP;
/*   7:    */ import br.com.interpsync.retreadsystem.modelo.Desreforma_ERP;
/*   8:    */ import br.com.interpsync.retreadsystem.modelo.Osvr_ERP;
/*   9:    */ import br.com.interpsync.saci.dao.Prd_SACIDAO;
/*  10:    */ import br.com.interpsync.saci.dao.Stk_SACIDAO;
/*  11:    */ import br.com.interpsync.saci.dao.Stkmov_SACIDAO;
/*  12:    */ import br.com.interpsync.saci.dao.Xa_SACIDAO;
/*  13:    */ import br.com.interpsync.saci.modelo.Stk_SACI;
/*  14:    */ import br.com.interpsync.saci.modelo.Stkmov_SACI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*  15:    */ import java.io.PrintStream;
/*  16:    */ import java.math.BigDecimal;
/*  17:    */ import java.sql.SQLException;
/*  18:    */ import java.text.SimpleDateFormat;
/*  19:    */ import java.util.Date;
/*  20:    */ import java.util.logging.Level;
/*  21:    */ import java.util.logging.Logger;
/*  22:    */ import org.apache.commons.mail.Email;
/*  23:    */ import org.apache.commons.mail.SimpleEmail;
/*  24:    */ 
/*  25:    */ public class BaixaEstoque
/*  26:    */ {
                private String hostEmail = "";
                private String portEmail = "";
                private String userEmail = "";
                private String passEmail = "";
                private String fromEmail = "";
                private String toEmail = "";
/*  27:    */   public void executar()
/*  28:    */   {
                   /*Inicio - Pegar Configurações de email do arquivo*/
                  try {
                  String local = new File("./email.txt").getCanonicalFile().toString();
                  File arq = new File(local);
                  boolean existe = arq.exists();        
                      if (existe){
                          FileReader fr = new FileReader( arq );
                          BufferedReader br = new BufferedReader( fr );
                          while(br.ready()){
                              String linha = br.readLine();
                              if(linha.contains("host:")){
                                  hostEmail = linha.replace("host:", "").replace(" ", "");
                              }
                              if(linha.contains("port:")){
                                  portEmail = linha.replace("port:", "").replace(" ", "");
                              }
                              if(linha.contains("user:")){
                                  userEmail = linha.replace("user:", "").replace(" ", "");
                              }
                              if(linha.contains("pass:")){
                                  passEmail = linha.replace("pass:", "").replace(" ", "");
                              }
                              if(linha.contains("from:")){
                                  fromEmail = linha.replace("from:", "").replace(" ", "");
                              }
                              if(linha.contains("to:")){
                                  toEmail = linha.replace("to:", "").replace(" ", "");
                              }
                          }
                     
                      } 
                   } catch (FileNotFoundException ex) {
                          Logger.getLogger(BaixaEstoque.class.getName()).log(Level.SEVERE, null, ex);
                          StackTraceElement st[] = ex.getStackTrace();
                          String erro = "";
                          for (int i = 0;i < st.length;i++){
                              erro += st[i].toString() + "\n";
                          } 
                          new Geralog().enviar("BaixaEstoque", erro);
                   } catch (IOException ex) {
                          Logger.getLogger(BaixaEstoque.class.getName()).log(Level.SEVERE, null, ex);
                          StackTraceElement st[] = ex.getStackTrace();
                          String erro2 = "";
                          for (int i = 0;i < st.length;i++){
                              erro2 += st[i].toString() + "\n";
                          } 
                          new Geralog().enviar("BaixaEstoque", erro2);
                  }
                  /*FIM - Pegar Configurações de email do arquivo*/
    
/*  29: 32 */     Osvr_INTERDBDAO osvrDAO = new Osvr_INTERDBDAO();
/*  30:    */     try
/*  31:    */     {
/*  32: 34 */       for (Osvr_ERP osvr : osvrDAO.listarPendentes())
/*  33:    */       {
/*  34: 35 */         System.out.println("Baixando Os: " + osvr.getNrOS() + " Tipo: " + osvr.getTipoReg());
/*  35:    */         
/*  36: 37 */         String Produto = new Prd_SACIDAO().localizarPorCampo(osvr.getTipoReg(), osvr.getCodigoReg());
/*  37: 38 */         if (Produto == null)
/*  38:    */         {
/*  39: 39 */           Email email = new SimpleEmail();
/*  40: 40 */           email.setHostName(hostEmail);
/*  41: 41 */           email.setSmtpPort(Integer.parseInt(portEmail));
/*  42: 42 */           email.setAuthentication(userEmail, passEmail);
/*  43: 43 */           email.setFrom(fromEmail);
/*  44: 44 */           email.setSubject("Erro na Integração SACI x Retread System");
/*  45: 45 */           email.setMsg("Produto Baixando na produção não foi localizado no SACI: " + osvr.getCodigoReg() + " Tipo: " + osvr.getTipoReg());
/*  46:    */           
/*  47: 47 */           email.addTo(toEmail);
/*  48: 48 */           email.send();
/*  49:    */         }
/*  50:    */         else
/*  51:    */         {
/*  52: 50 */           System.out.println("Pronto: " + Produto);
/*  53:    */           
/*  54: 52 */           Stk_SACIDAO estoqueDAO = new Stk_SACIDAO();
/*  55: 53 */           Stk_SACI estoque = estoqueDAO.getEstoque(Produto);
/*  56:    */           
/*  57: 55 */           BigDecimal peso = BigDecimal.ONE;
/*  58: 56 */           if (osvr.getTipoReg().equals("B")) {
/*  59: 57 */             peso = new Desreforma_INTERDBDAO().localizarPorID(osvr.getCodigoReg()).getPesoDE();
/*  60: 59 */           } else if (osvr.getTipoReg().equals("C")) {
/*  61: 60 */             peso = new Coxins_INTERDBDAO().localizarPorId(osvr.getCodigoReg()).getPesoCX();
/*  62:    */           } else {
/*  63: 62 */             peso = BigDecimal.ONE;
/*  64:    */           }
/*  65: 66 */           BigDecimal novoEstoque = new BigDecimal(estoque.getQtty_varejo().longValue());
/*  66: 67 */           novoEstoque = novoEstoque.divide(new BigDecimal(1000L));
/*  67: 68 */           BigDecimal qtdOS = BigDecimal.ZERO;
/*  68: 69 */           if ((osvr.getTipoReg().equals("B")) || (osvr.getTipoReg().equals("C"))) {
/*  69: 70 */             qtdOS = osvr.getQtde().divide(new BigDecimal(1000L));
/*  70:    */           } else {
/*  71: 72 */             qtdOS = osvr.getQtde();
/*  72:    */           }
/*  73: 74 */           qtdOS = qtdOS.multiply(peso);
/*  74: 75 */           novoEstoque = novoEstoque.subtract(qtdOS);
/*  75: 76 */           novoEstoque = novoEstoque.multiply(new BigDecimal(1000L));
/*  76:    */           
/*  77:    */ 
/*  78: 79 */           estoque.setQtty_varejo(Long.valueOf(novoEstoque.longValue()));
/*  79:    */           
/*  80: 81 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*  81: 82 */           sdf.format(new Date(System.currentTimeMillis()));
/*  82: 83 */           String datahj = sdf.format(new Date(System.currentTimeMillis()));
/*  83: 84 */           estoque.setLastchangedt(Long.valueOf(Long.parseLong(datahj)));
/*  84:    */           
/*  85: 86 */           estoqueDAO.AtualizarEstoque(estoque);
/*  86:    */           
/*  87: 88 */           Stkmov_SACI movimento = new Stkmov_SACI();
/*  88: 89 */           movimento.setXano(new Xa_SACIDAO().NovaTrans());
/*  89: 90 */           movimento.setStoreno(Integer.valueOf(4));
/*  90: 91 */           movimento.setPrdno(Produto);
/*  91: 92 */           movimento.setRemarks("BAIXA DE EST PRODUCAO OS: "+osvr.getNrOS());
/*  92: 93 */           movimento.setQtty(Long.valueOf(qtdOS.multiply(new BigDecimal(-1000)).longValue()));
/*  93: 94 */           movimento.setData(Long.valueOf(Long.parseLong(datahj)));
/*  94: 95 */           movimento.setCm_fiscal(Long.valueOf(Long.parseLong("10000")));
/*  95: 96 */           movimento.setCm_real(Long.valueOf(Long.parseLong("10000")));
/*  96: 97 */           movimento.setBits(Integer.valueOf(1));
/*  97: 98 */           Stkmov_SACIDAO movimentoDAO = new Stkmov_SACIDAO();
/*  98: 99 */           movimentoDAO.inserir(movimento);
/*  99:    */           
/* 100:101 */           osvr.setStatusERP(1);
/* 101:102 */           osvrDAO.atualizar(osvr);
/* 102:    */         }
/* 103:    */       }
/* 104:    */     }
/* 105:    */     catch (ClassNotFoundException ex)
/* 106:    */     {
/* 107:106 */       Logger.getLogger(BaixaEstoque.class.getName()).log(Level.SEVERE, null, ex);
                    StackTraceElement st[] = ex.getStackTrace();
                    String erro = "";
                    for (int i = 0;i < st.length;i++){
                              erro += st[i].toString() + "\n";
                    } 
                    new Geralog().enviar("BaixaEstoque", erro);
/* 108:    */     }
/* 109:    */     catch (SQLException ex)
/* 110:    */     {
/* 111:108 */       Logger.getLogger(BaixaEstoque.class.getName()).log(Level.SEVERE, null, ex);
                    StackTraceElement st[] = ex.getStackTrace();
                    String erro2 = "";
                    for (int i = 0;i < st.length;i++){
                         erro2 += st[i].toString() + "\n";
                    } 
                    new Geralog().enviar("BaixaEstoque", erro2);
/* 112:    */     }
/* 113:    */     catch (Exception ex)
/* 114:    */     {
/* 115:110 */       Logger.getLogger(BaixaEstoque.class.getName()).log(Level.SEVERE, null, ex);
                    StackTraceElement st[] = ex.getStackTrace();
                    String erro3 = "";
                    for (int i = 0;i < st.length;i++){
                        erro3 += st[i].toString() + "\n";
                    } 
                    new Geralog().enviar("BaixaEstoque", erro3);
/* 116:    */     }
/* 117:    */   }
/* 118:    */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.controller.BaixaEstoque

 * JD-Core Version:    0.7.0.1

 */