/*  1:   */ package br.com.interpsync.retreadsystem.jdbc;
/*  2:   */ 
import br.com.interpsync.controller.Geralog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/*  3:   */ import java.sql.Connection;
/*  4:   */ import java.sql.DriverManager;
/*  5:   */ import java.sql.SQLException;
/*  6:   */ 
/*  7:   */ public class ConnectionFactory
/*  8:   */ {
/*  9:   */   private static ConnectionFactory connectionFactory;
/* 10:   */   private Connection connection;
/* 11:   */   
/* 12:   */   public static ConnectionFactory getInstance()
/* 13:   */   {
/* 14:24 */     if (connectionFactory == null) {
/* 15:25 */       connectionFactory = new ConnectionFactory();
/* 16:   */     }
/* 17:27 */     return connectionFactory;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public Connection obterConexao()
/* 21:   */     throws SQLException, ClassNotFoundException, Exception
/* 22:   */   {
    
                /*Inicio lendo configurações para o banco*/  
                  String dsncf = "";
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
                                  if(linha.contains("RSDSN:")){
                                      dsncf = linha.replace("RSDSN:", "").replace(" ", "");
                                  }
                                  if(linha.contains("RSDSNuser:")){
                                      user = linha.replace("RSDSNuser:", "").replace(" ", "");
                                  }
                                  if(linha.contains("RSDSNpass:")){
                                      pass = linha.replace("RSDSNpass:", "").replace(" ", "");
                                  }
                              }

                       }
                  } catch (Exception e) {
                      StackTraceElement st[] = e.getStackTrace();
                      String erro = "";
                      for (int i = 0;i < st.length;i++){
                          erro += st[i].toString() + "\n";
                      } 
                      new Geralog().enviar("BaixaEstoque - Retread", erro);
                  }
                /*Fim lendo configurações para o banco*/ 
/* 23:33 */     if ((this.connection == null) || (this.connection.isClosed()))
/* 24:   */     {
/* 25:34 */       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
/* 26:35 */       String DSN = dsncf;
/* 27:36 */       String url = "jdbc:odbc:" + DSN;
/* 28:   */       try
/* 29:   */       {
/* 30:38 */         this.connection = DriverManager.getConnection(url, user, pass);
/* 31:39 */         if (this.connection != null) {
/* 32:40 */           return this.connection;
/* 33:   */         }
/* 34:   */       }
/* 35:   */       catch (Exception ex)
/* 36:   */       {
/* 37:43 */         ex.printStackTrace();
/* 38:44 */         throw new Exception("Conexao com a producao nao realizada");
/* 39:   */       }
/* 40:46 */       return this.connection;
/* 41:   */     }
/* 42:48 */     return this.connection;
/* 43:   */   }
/* 44:   */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.retreadsystem.jdbc.ConnectionFactory

 * JD-Core Version:    0.7.0.1

 */