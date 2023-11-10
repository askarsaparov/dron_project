package kibera.dron_project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tracker_data")
@Entity
public class TrackerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "length")
    private String length;

    @Column(name = "record")
    private String record;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "priority")
    private String priority;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "altitude")
    private String altitude;

    @Column(name = "angle")
    private String angle;

    @Column(name = "satellites")
    private String satellites;

    @Column(name = "speed")
    private String speed;

    @Column(name = "drone_id")
    private String drone_id;

    public TrackerData id(Long id) {
        this.id = id;
        return this;
    }

    public TrackerData length(String length) {
        this.length = length;
        return this;
    }

    public TrackerData record(String record) {
        this.record = record;
        return this;
    }

    public TrackerData timestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public TrackerData priority(String priority) {
        this.priority = priority;
        return this;
    }

    public TrackerData latitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public TrackerData longitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public TrackerData altitude(String altitude) {
        this.altitude = altitude;
        return this;
    }

    public TrackerData angle(String angle) {
        this.angle = angle;
        return this;
    }

    public TrackerData satellites(String satellites) {
        this.satellites = satellites;
        return this;
    }

    public TrackerData speed(String speed) {
        this.speed = speed;
        return this;
    }

    public TrackerData drone_id(String drone_id) {
        this.drone_id = drone_id;
        return this;
    }
}
