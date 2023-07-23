package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionsPoolImpl implements ConnectionsPool {
	int limit; // limit of connections number in a pool
	LinkedHashMap<Integer, Connection> map;
	
	public ConnectionsPoolImpl (int limit) {
		map = new LinkedHashMap<>(16, 0.75f, true ) {
			@Override//extends LinkedHashMap
			protected boolean removeEldestEntry (Map.Entry<Integer, Connection> eldestEntry) {
				return size() > limit;
			}
		};
		this.limit = limit;
	}
	// true if added otherwise false if a connection already exists 
	//in the case the Connection Pool is full the eldest connection will be removed
	@Override
	public boolean addConnection(Connection connection) {	
		
		return map.put(connection.id, connection) == null ? true : false;
	}

	//Connection if exists otherwise null
	 // moves the connection to the first order-access of Connection Pool
	@Override
	public Connection getConnection(int id) {
		
		return map.get(id);
	}

}
