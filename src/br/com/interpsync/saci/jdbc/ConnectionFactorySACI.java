/*  1:   */ package br.com.interpsync.saci.jdbc;
/*  2:   */ 
import br.com.interpsync.controller.Geralog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/*  3:   */ import java.sql.Connection;
/*  4:   */ import java.sql.DriverManager;
/*  5:   */ import java.sql.SQLException;
/*  6:   */ 
/*  7:   */ public class ConnectionFactorySACI
/*  8:   */ {
/*  9:   */   private static ConnectionFactorySACI connectionFactory;
/* 10:   */   private Connection connection;
/* 11:   */   
/* 12:   */   public static ConnectionFactorySACI getInstance()
/* 13:   */   {
/* 14:23 */     if (connectionFactory == null) {
/* 15:24 */       connectionFactory = new ConnectionFactorySACI();
/* 16:   */     }
/* 17:26 */     return connectionFactory;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public Connection obterConexao()
/* 21:   */     throws SQLException, ClassNotFoundException, Exception
/* 22:   */   {
    
                /*Inicio lendo configurações para o banco*/  
                  String host = "";
                  String db = "";
                  String user = "";
                  String pass = "";
                  try {
                      String local = new File("./bdconfig.txt").getCanonicalFile().toString();
                      File arq = new File(local);
                      boolean existe = arq.exists();        
                      if (existe){
                              FileReader fr = new FileReader( arq );
                              BufferedReader br = new BufferedReader( fr );
                              while(br.ready()){
                                  String linha = br.readLine();
                                  if(linha.contains("SACIHost:")){
                                      host = linha.replace("SACIHost:", "").replace(" ", "");
                                  }
                                  if(linha.contains("SACIdb:")){
                                      db = linha.replace("SACIdb:", "").replace(" ", "");
                                  }
                                  if(linha.contains("SACIuser:")){
                                      user = linha.replace("SACIuser:", "").replace(" ", "");
                                  }
                                  if(linha.contains("SACIpass:")){
                                      pass = linha.replace("SACIpass:", "").replace(" ", "");
                                  }
                              }

                       }
                  } catch (Exception e) {
                      StackTraceElement st[] = e.getStackTrace();
                      String erro = "";
                      for (int i = 0;i < st.length;i++){
                          erro += st[i].toString() + "\n";
                      }        
                      new Geralog().enviar("BaixaEstoque - SACI", erro);
                  }
                /*Fim lendo configurações para o banco*/ 
/* 23:33 */     if ((this.connection == null) || (this.connection.isClosed()))
/* 24:   */     {
/* 25:34 */       Class.forName("com.mysql.jdbc.Driver");
/* 26:35 */       String serverName = host;
/* 27:36 */       String banco = db;
/* 28:37 */       String url = "jdbc:mysql://" + serverName + "/" + banco;
/* 29:   */       try
/* 30:   */       {
/* 31:39 */         this.connection = DriverManager.getConnection(url, user, pass);
/* 32:40 */         if (this.connection != null) {
/* 33:41 */           return this.connection;
/* 34:   */         }
/* 35:   */       }
/* 36:   */       catch (Exception ex)
/* 37:   */       {
/* 38:44 */         ex.printStackTrace();
/* 39:45 */         throw new Exception("ConexÃ£o com o banco do SACI nÃ£o realizada");
/* 40:   */       }
/* 41:47 */       return this.connection;
/* 42:   */     }
/* 43:49 */     return this.connection;
/* 44:   */   }
/* 45:   */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.saci.jdbc.ConnectionFactorySACI

 * JD-Core Version:    0.7.0.1

 */