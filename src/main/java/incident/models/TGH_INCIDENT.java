package incident.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "TGH_INCIDENT")
public class TGH_INCIDENT {
    @Id
    @Column(name = "INCIDENT_ID")
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "INC_SEQ")
    @SequenceGenerator(name = "INC_SEQ",sequenceName = "INC_SEQ",allocationSize = 1)*/
    private long incidentId;
    @Column(name = "TGH_ID")
    private long tghId;
    @Column(name = "CALLER_NAME")
    private String callerName;
    @Column(name = "CALLER_ADDRESS")
    private String callerAddress;
    @Column(name = "CALLER_TEL_NO")
    private String callerTelNo;
    @ManyToOne
    @JoinColumn(name ="STATUS_CODE" )
    private TGH_INCIDENT_STATUS statusCode;
    @ManyToOne
    @JoinColumn(name = "INCIDENT_TYPE_CODE")
    private TGH_INCIDENT_TYPE incidentTypeCode;
    @Column(name = "INCIDENT_NOTES")
    private String incidentNotes;
    @Column(name = "CALLER_CITY_CODE")
    private String callerCityCode;
    @Column(name = "QUERY_FLAG")
    private int queryFlag;
    @Column(name = "RECIEVED_BY")
    private String recievedBy;
    @Column(name = "RECIEVED_DATE")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date recievedDate;
    @Column(name = "RECORD_STATUS")
    private String recordStatus;
    @Column(name = "CUSTOMER_MOBILE_NUMBER")
    private String customerMobileNumber;
    @Column(name = "ARCHIVED_BY")
    @JsonIgnore
    private String archivedBy;
    @OneToMany(mappedBy = "tgh_incident")
    @JsonIgnore
    private Set<TGH_INCIDENT_FOLLOWUP>tgh_incident_followupSet = new HashSet<>();
}
