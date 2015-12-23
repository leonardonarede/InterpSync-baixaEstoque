/*  1:   */ package br.com.interpsync.saci.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*  4:   */ import br.com.interpsync.saci.modelo.Oprd_SACI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.SQLException;
/*  8:   */ import java.util.logging.Level;
/*  9:   */ import java.util.logging.Logger;
/* 10:   */ 
/* 11:   */ public class Oprd_SACIDAO
/* 12:   */ {
/* 13:   */   private Connection conexao;
              private Integer Loja = Integer.valueOf(0);
/* 14:   */   
/* 15:   */   public Oprd_SACIDAO()
/* 16:   */   {
/* 17:   */     try
/* 18:   */     {
/* 19:24 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
                  String local = new File("./bdconfig.txt").getCanonicalFile().toString();
                  File arq = new File(local);
                  boolean existe = arq.exists();  
                  if (existe){
                      FileReader fr = new FileReader( arq );
                      BufferedReader br = new BufferedReader( fr );
                      while(br.ready()){
                          String linha = br.readLine();
                          if(linha.contains("SACILoja:")){
                             Loja = Integer.parseInt(linha.replace("SACILoja:", "").replace(" ", ""));
                          }
                      }
                  }
/* 20:   */     }
/* 21:   */     catch (SQLException ex)
/* 22:   */     {
/* 23:26 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 24:   */     }
/* 25:   */     catch (ClassNotFoundException ex)
/* 26:   */     {
/* 27:28 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 28:   */     }
/* 29:   */     catch (Exception ex)
/* 30:   */     {
/* 31:30 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 32:   */     }
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Connection getConnection()
/* 36:   */     throws SQLException, ClassNotFoundException, Exception
/* 37:   */   {
/* 38:38 */     if ((this.conexao == null) || (this.conexao.isClosed())) {
/* 39:39 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 40:   */     }
/* 41:41 */     return this.conexao;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void inserir(Oprd_SACI oprd)
/* 45:   */     throws ClassNotFoundException, SQLException, Exception
/* 46:   */   {
/* 47:48 */     String sql = "INSERT INTO oprd (storeno, ordno, prdno, grade, qtty, mult, cost, status, remarks)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
/* 48:   */     
/* 49:50 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 50:51 */     stmt.setInt(1, Loja);
/* 51:52 */     stmt.setInt(2, oprd.getOrdno().intValue());
/* 52:53 */     stmt.setString(3, oprd.getPrdno());
/* 53:54 */     stmt.setString(4, oprd.getGrade());
/* 54:55 */     stmt.setInt(5, oprd.getQtty().intValue());
/* 55:56 */     stmt.setInt(6, oprd.getMult().intValue());
/* 56:57 */     stmt.setInt(7, oprd.getCost().intValue());
/* 57:58 */     stmt.setInt(8, oprd.getStatus().intValue());
/* 58:59 */     stmt.setString(9, oprd.getRemarks());
/* 59:60 */     stmt.executeUpdate();
/* 60:61 */     stmt.close();
/* 61:   */   }
/* 62:   */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.saci.dao.Oprd_SACIDAO

 * JD-Core Version:    0.7.0.1

 */