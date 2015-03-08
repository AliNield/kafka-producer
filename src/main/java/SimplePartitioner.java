import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class SimplePartitioner implements Partitioner{

    public SimplePartitioner (VerifiableProperties props) {

    }

    @Override
    public int partition(Object key, int numberOfPartitions) {
        int partition = 0;
        String stringKey = (String) key;
        int offset = stringKey.lastIndexOf(".");
        if(offset > 0 ) {
            partition = Integer.parseInt(stringKey.substring(offset+1)) % numberOfPartitions;
        }
        return partition;
    }
}
