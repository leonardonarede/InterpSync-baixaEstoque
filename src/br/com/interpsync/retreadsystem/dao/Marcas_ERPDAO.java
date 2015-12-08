/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Marcas_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Marcas_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Marcas_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 29 */       Logger.getLogger(Marcas_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 31 */       Logger.getLogger(Marcas_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 33 */       Logger.getLogger(Marcas_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Connection getConnection()
/*  39:    */     throws SQLException, ClassNotFoundException, Exception
/*  40:    */   {
/*  41: 41 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  42: 42 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  43:    */     }
/*  44: 44 */     return this.connection;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public List<Marcas_ERP> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "SELECT ALL * FROM MARCAS_ERP";
/*  51: 52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 53 */     stmt.executeQuery();
/*  53: 54 */     ResultSet rs = stmt.getResultSet();
/*  54: 55 */     List<Marcas_ERP> marcas = new ArrayList();
/*  55: 56 */     while (rs.next())
/*  56:    */     {
/*  57: 57 */       Marcas_ERP marca = new Marcas_ERP();
/*  58: 58 */       marca.setCodMA(rs.getString("CodMA"));
/*  59: 59 */       marca.setDescrMA(rs.getString("DescrMA"));
/*  60: 60 */       marca.setTipoMA(rs.getString("TipoMA"));
/*  61: 61 */       marca.setStEI(rs.getInt("StEI"));
/*  62: 62 */       marcas.add(marca);
/*  63:    */     }
/*  64: 64 */     stmt.close();
/*  65: 65 */     return marcas;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public List<Marcas_ERP> listarNovos()
/*  69:    */     throws SQLException, ClassNotFoundException, Exception
/*  70:    */   {
/*  71: 73 */     String sql = "SELECT * FROM MARCAS_ERP WHERE StEI <> 1";
/*  72: 74 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  73: 75 */     stmt.executeQuery();
/*  74: 76 */     ResultSet rs = stmt.getResultSet();
/*  75: 77 */     List<Marcas_ERP> marcas = new ArrayList();
/*  76: 78 */     while (rs.next())
/*  77:    */     {
/*  78: 79 */       Marcas_ERP marca = new Marcas_ERP();
/*  79: 80 */       marca.setCodMA(rs.getString("CodMA"));
/*  80: 81 */       marca.setDescrMA(rs.getString("DescrMA"));
/*  81: 82 */       marca.setTipoMA(rs.getString("TipoMA"));
/*  82: 83 */       marca.setStEI(rs.getInt("StEI"));
/*  83: 84 */       marcas.add(marca);
/*  84:    */     }
/*  85: 86 */     stmt.close();
/*  86: 87 */     return marcas;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void atualizar(Marcas_ERP marca)
/*  90:    */     throws ClassNotFoundException, SQLException, Exception
/*  91:    */   {
/*  92: 94 */     String sql = "UPDATE MARCAS_ERP SET DescrMA = ?, TipoMA = ?, StEI = ? WHERE CodMA = ?";
/*  93: 95 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  94: 96 */     stmt.setString(1, marca.getDescrMA());
/*  95: 97 */     stmt.setString(2, marca.getTipoMA());
/*  96: 98 */     stmt.setInt(3, marca.getStEI());
/*  97: 99 */     stmt.setString(4, marca.getCodMA());
/*  98:100 */     stmt.executeUpdate();
/*  99:101 */     stmt.close();
/* 100:    */   }
/* 101:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Marcas_ERPDAO
 * JD-Core Version:    0.7.0.1
 */