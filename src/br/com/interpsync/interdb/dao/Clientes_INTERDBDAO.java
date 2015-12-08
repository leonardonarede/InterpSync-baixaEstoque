/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Clientes_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.SQLException;
/*  8:   */ import java.util.logging.Level;
/*  9:   */ import java.util.logging.Logger;
/* 10:   */ 
/* 11:   */ public class Clientes_INTERDBDAO
/* 12:   */ {
/* 13:   */   private Connection connection;
/* 14:   */   
/* 15:   */   public Clientes_INTERDBDAO()
/* 16:   */   {
/* 17:   */     try
/* 18:   */     {
/* 19:24 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 20:   */     }
/* 21:   */     catch (SQLException ex)
/* 22:   */     {
/* 23:26 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 24:   */     }
/* 25:   */     catch (ClassNotFoundException ex)
/* 26:   */     {
/* 27:28 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 28:   */     }
/* 29:   */     catch (Exception ex)
/* 30:   */     {
/* 31:30 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 32:   */     }
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Connection getConnection()
/* 36:   */     throws SQLException, ClassNotFoundException, Exception
/* 37:   */   {
/* 38:38 */     if ((this.connection == null) || (this.connection.isClosed())) {
/* 39:39 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 40:   */     }
/* 41:41 */     return this.connection;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void inserir(Clientes_ERP cliente)
/* 45:   */     throws SQLException, ClassNotFoundException, Exception
/* 46:   */   {
/* 47:48 */     String sql = "INSERT INTO clientes_erp (CNPJCPF,NomeCLI,EndeCLI,NrCLI,BairroCLI,CidadeCLI,EstadoCLI,CepCLI,IERGCLI,FJCLI,VendR,VendP,VendS,PrazoR,PrazoP,PrazoS,ComissaoNF,ComissaoTit,RespVencidas,RespAVencer,CodConceito,LimiteCrd,NContato,TContato,StEI) VALUES (? ,? ,? ,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
/* 48:   */     
/* 49:   */ 
/* 50:   */ 
/* 51:52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 52:53 */     stmt.setString(1, cliente.getCNPJCPF());
/* 53:54 */     stmt.setString(2, cliente.getNomeCLI());
/* 54:55 */     stmt.setString(3, cliente.getEndeCLI());
/* 55:56 */     stmt.setString(4, cliente.getNrCLI());
/* 56:57 */     stmt.setString(5, cliente.getBairroCLI());
/* 57:58 */     stmt.setString(6, cliente.getCidadeCLI());
/* 58:59 */     stmt.setString(7, cliente.getEstadoCLI());
/* 59:60 */     stmt.setString(8, cliente.getCepCLI());
/* 60:61 */     stmt.setString(9, cliente.getIERGCLI());
/* 61:62 */     stmt.setString(10, cliente.getFJCLI());
/* 62:63 */     stmt.setString(11, cliente.getVendR());
/* 63:64 */     stmt.setString(12, cliente.getVendP());
/* 64:65 */     stmt.setString(13, cliente.getVendS());
/* 65:66 */     stmt.setString(14, cliente.getPrazoR());
/* 66:67 */     stmt.setString(15, cliente.getPrazoP());
/* 67:68 */     stmt.setString(16, cliente.getPrazoS());
/* 68:69 */     stmt.setBigDecimal(17, cliente.getComissaoNF());
/* 69:70 */     stmt.setBigDecimal(18, cliente.getComissaoTit());
/* 70:71 */     stmt.setBigDecimal(19, cliente.getRespVencidas());
/* 71:72 */     stmt.setBigDecimal(20, cliente.getRespAVencer());
/* 72:73 */     stmt.setString(21, cliente.getCodConceito());
/* 73:74 */     stmt.setString(22, cliente.getLimiteCrd());
/* 74:75 */     stmt.setString(23, cliente.getNContato());
/* 75:76 */     stmt.setString(24, cliente.getTContato());
/* 76:77 */     stmt.setInt(25, cliente.getStEI());
/* 77:78 */     stmt.executeUpdate();
/* 78:79 */     stmt.close();
/* 79:   */   }
/* 80:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Clientes_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */