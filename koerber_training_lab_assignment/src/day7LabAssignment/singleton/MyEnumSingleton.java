package day7LabAssignment.singleton;

 public enum MyEnumSingleton {
     instance;
}
// Enum inherently is thread safe serialisation safe
// and has reflection safety and doesn't allow clonning
