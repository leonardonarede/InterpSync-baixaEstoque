/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Marcas_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Marcas_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Marcas_INTERDBDAO()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:25 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 21:   */     }
/* 22:   */     catch (SQLException ex)
/* 23:   */     {
/* 24:27 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 25:   */     }
/* 26:   */     catch (ClassNotFoundException ex)
/* 27:   */     {
/* 28:29 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 29:   */     }
/* 30:   */     catch (Exception ex)
/* 31:   */     {
/* 32:31 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 33:   */     }
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Connection getConnection()
/* 37:   */     throws SQLException, ClassNotFoundException, Exception
/* 38:   */   {
/* 39:39 */     if ((this.connection == null) || (this.connection.isClosed())) {
/* 40:40 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 41:   */     }
/* 42:42 */     return this.connection;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void inserir(Marcas_ERP marca)
/* 46:   */     throws ClassNotFoundException, SQLException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO MARCAS_ERP (CodMA,DescrMA,TipoMA,StEI)  VALUES (?,?,?,?);";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, marca.getCodMA());
/* 52:53 */     stmt.setString(2, marca.getDescrMA());
/* 53:54 */     stmt.setString(3, marca.getTipoMA());
/* 54:55 */     stmt.setInt(4, marca.getStEI());
/* 55:56 */     stmt.executeUpdate();
/* 56:57 */     stmt.close();
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void atualizar(Marcas_ERP marca)
/* 60:   */     throws ClassNotFoundException, SQLException, Exception
/* 61:   */   {
/* 62:64 */     String sql = "UPDATE MARCAS_ERP SET DescrMA = ?, TipoMA = ?, StEI = ?    WHERE CodMA = ?";
/* 63:   */     
/* 64:66 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 65:67 */     stmt.setString(1, marca.getDescrMA());
/* 66:68 */     stmt.setString(2, marca.getTipoMA());
/* 67:69 */     stmt.setInt(3, marca.getStEI());
/* 68:70 */     stmt.setString(4, marca.getCodMA());
/* 69:71 */     stmt.executeUpdate();
/* 70:72 */     stmt.close();
/* 71:   */   }
/* 72:   */   
/* 73:   */   public Marcas_ERP localizarPorID(String id)
/* 74:   */     throws ClassNotFoundException, SQLException, Exception
/* 75:   */   {
/* 76:79 */     String sql = "SELECT CodMA, DescrMA, TipoMA, StEI FROM MARCAS_ERP WHERE CodMA = ?";
/* 77:80 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 78:81 */     stmt.setString(1, id);
/* 79:82 */     stmt.executeQuery();
/* 80:83 */     ResultSet rs = stmt.getResultSet();
/* 81:84 */     Marcas_ERP marca = new Marcas_ERP();
/* 82:85 */     if (rs.next())
/* 83:   */     {
/* 84:86 */       marca.setCodMA(rs.getString("CodMA"));
/* 85:87 */       marca.setDescrMA(rs.getString("DescrMA"));
/* 86:88 */       marca.setTipoMA(rs.getString("TipoMA"));
/* 87:89 */       marca.setStEI(rs.getInt("StEI"));
/* 88:   */     }
/* 89:91 */     stmt.close();
/* 90:92 */     return marca;
/* 91:   */   }
/* 92:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Marcas_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */