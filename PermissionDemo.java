import java.util.ArrayList;
import java.util.List;

public class PermissionDemo {

    sealed interface PermissionDecision permits Allowed, Denied {}

    record Allowed(List<String> permissions)
            implements PermissionDecision {

        public Allowed {
            permissions = List.copyOf(permissions);
        }
    }

    record Denied(String reason)
            implements PermissionDecision {}

    static String format(PermissionDecision decision) {
        return switch (decision) {
            case Allowed allowed ->
                    "Allowed permissions: " + allowed.permissions();

            case Denied denied ->
                    "Denied because: " + denied.reason();
        };
    }

    public static void main(String[] args) {
        List<String> originalPermissions = new ArrayList<>();
        originalPermissions.add("READ");

        Allowed allowed = new Allowed(originalPermissions);
        Denied denied = new Denied("Admin role required");

        // Modify the original list after constructing the record.
        originalPermissions.add("DELETE");

        // Still [READ] because the record made a defensive copy.
        System.out.println(allowed.permissions());

        // Generated record toString().
        System.out.println(allowed);

        // Pattern-matching switch for both permitted types.
        System.out.println(format(allowed));
        System.out.println(format(denied));

        // Records compare their component values.
        System.out.println(
                denied.equals(new Denied("Admin role required"))
        );

        // The copied list cannot be modified.
        try {
            allowed.permissions().add("WRITE");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Permissions cannot be modified");
        }
    }
}