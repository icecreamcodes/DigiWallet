//package com.orion.DigiWallet.model;
//
////TODO: 3.3
//// Define this class as a JPA entity mapped to "rewards_point" table
//// ADD @table annotation to specify the table name as "rewards_point"
//public class RewardsPoint {
//
//    //TODO: 3.3.1
//    // Define id as primary key with auto-generation strategy
//
//    //TODO: 3.3.2
//    // Define points field to store the number of reward points
//
//    //TODO: 3.3.3
//    // Define wallet field to establish many-to-one relationship with Wallet entity
//    // Use @JoinColumn with name "wallet_id" and make it NOT NULL
//
//    //TODO: 3.3.4
//    // Define updatedAt field to store the timestamp of last update
//    // This value should be automatically updated whenever points are modified
//
//    //TODO: 3.3.5
//    // Generate getters and setters for all fields
//
//    //TODO: 3.3.6
//    // THIS TABLE IS NOT THERE IN MYSQL SO WHEN YOU RUN IT JPA WILL CREATE IT AUTOMATICALLY
//    // GO TO MYSQL AND VERIFY IF THE TABLE IS CREATED OR NOT
//    // ALSO CHECK FIELD NAMES AND TYPES
//    // WITH CONSTRAINTS
//
//}


package com.orion.DigiWallet.model;

import jakarta.persistence.*;
        import java.time.LocalDateTime;

@Entity
@Table(name = "rewards_point")
public class RewardsPoint {

    // 3.3.1 Primary key with auto-generation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 3.3.2 Number of reward points
    @Column(nullable = false)
    private int points;

    // 3.3.3 Many-to-one relationship with Wallet
    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    // 3.3.4 Timestamp of last update
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Automatically set/update timestamp
    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();
    }

    // 3.3.5 Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
