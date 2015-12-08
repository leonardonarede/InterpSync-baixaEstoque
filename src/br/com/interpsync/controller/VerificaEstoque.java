/*  1:   */ package br.com.interpsync.controller;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.dao.OS_INTERDBDAO;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.OS_ERP;
/*  5:   */ import java.sql.SQLException;
/*  6:   */ import java.util.Date;
/*  7:   */ import java.util.logging.Level;
/*  8:   */ import java.util.logging.Logger;
/*  9:   */ import org.apache.commons.mail.Email;
/* 10:   */ import org.apache.commons.mail.SimpleEmail;
/* 11:   */ 
/* 12:   */ public class VerificaEstoque
/* 13:   */ {
/* 14:   */   private Long diff;
/* 15:   */   
/* 16:   */   public void executar()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:24 */       OS_INTERDBDAO osdao = new OS_INTERDBDAO();
/* 21:25 */       for (OS_ERP os : osdao.listarEstPendente())
/* 22:   */       {
/* 23:26 */         Date data = new Date();
/* 24:27 */         Long milis1 = Long.valueOf(data.getTime());
/* 25:28 */         Long milis2 = Long.valueOf(os.getDtPrefID().getTime());
/* 26:29 */         this.diff = Long.valueOf(milis1.longValue() - milis2.longValue());
/* 27:30 */         this.diff = Long.valueOf(this.diff.longValue() / 86400000L);
/* 28:31 */         if (this.diff.longValue() == 20L)
/* 29:   */         {
/* 30:32 */           Email email = new SimpleEmail();
/* 31:33 */           email.setHostName("smtp.cacique.srv.br");
/* 32:34 */           email.setSmtpPort(587);
/* 33:35 */           email.setAuthentication("leonardocpd@cacique.srv.br", "odranoel7541");
/* 34:36 */           email.setFrom("comunicacao@cacique.srv.br");
/* 35:37 */           email.setSubject("Aviso de Produção");
/* 36:38 */           email.setMsg("A OS : " + os.getNrOS() + " Está com " + this.diff + " no Estoque, " + " favor contactar o cliente.");
/* 37:   */           
/* 38:40 */           email.addTo("leonardocpd@cacique.srv.br");
/* 39:41 */           email.send();
/* 40:   */         }
/* 41:43 */         if (this.diff.longValue() == 30L)
/* 42:   */         {
/* 43:44 */           Email email = new SimpleEmail();
/* 44:45 */           email.setHostName("smtp.cacique.srv.br");
/* 45:46 */           email.setSmtpPort(587);
/* 46:47 */           email.setAuthentication("leonardocpd@cacique.srv.br", "odranoel7541");
/* 47:48 */           email.setFrom("comunicacao@cacique.srv.br");
/* 48:49 */           email.setSubject("Aviso de Produção");
/* 49:50 */           email.setMsg("A OS : " + os.getNrOS() + " Está com " + this.diff + " no Estoque, " + " favor contactar o cliente.");
/* 50:   */           
/* 51:52 */           email.addTo("leonardocpd@cacique.srv.br");
/* 52:53 */           email.send();
/* 53:   */         }
/* 54:   */       }
/* 55:   */     }
/* 56:   */     catch (ClassNotFoundException ex)
/* 57:   */     {
/* 58:57 */       Logger.getLogger(VerificaEstoque.class.getName()).log(Level.SEVERE, null, ex);
/* 59:   */     }
/* 60:   */     catch (SQLException ex)
/* 61:   */     {
/* 62:59 */       Logger.getLogger(VerificaEstoque.class.getName()).log(Level.SEVERE, null, ex);
/* 63:   */     }
/* 64:   */     catch (Exception ex)
/* 65:   */     {
/* 66:61 */       Logger.getLogger(VerificaEstoque.class.getName()).log(Level.SEVERE, null, ex);
/* 67:   */     }
/* 68:   */   }
/* 69:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.controller.VerificaEstoque
 * JD-Core Version:    0.7.0.1
 */