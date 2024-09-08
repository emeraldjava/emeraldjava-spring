package ie.emeraldjava.raft.microraft;

import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.requireNonNull;

public class RaftEndpoint implements io.microraft.RaftEndpoint {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    public static RaftEndpoint newEndpoint() {
        return new RaftEndpoint("node" + ID_GENERATOR.incrementAndGet());
    }

    private final String id;

    private RaftEndpoint(String id) {
        this.id = requireNonNull(id);
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RaftEndpoint that = (RaftEndpoint) o;

        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "LocalRaftEndpoint{" + "id=" + id + '}';
    }
}
