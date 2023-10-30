package incident.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "AR_INCIDENT")
public class AR_INCIDENT {
    @Id
    @Column(name = "INCIDENT_ID")
    private long code;
    @Column(name = "TGH_ID",insertable = false,updatable = false)
    private long tghId;
    @Column(name = "CALLER_NAME")
    private String callerName;
    @Column(name = "CALLER_ADDRESS")
    private String callerAddress;
    @Column(name = "CALLER_TEL_NO")
    private String callerTelNo;
    @Column(name = "CALLER_CITY_CODE")
    private String callerCityCode;
    @Column(name = "QUERY_FLAG")
    private int queryFlag;
    @Column(name = "INCIDENT_TYPE_CODE")
    private String incidentTypeCode;
    @Column(name = "STATUS_CODE")
    private String statusCode; //statusCode
    @Column(name = "INCIDENT_NOTES")
    private String incidentNotes; //incidentNotes
    @Column(name = "RECIEVED_BY")
    private String receivedBy;
    @Column(name = "RECIEVED_DATE")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date receivedDate;
    @Column(name = "ARCHIVE_DATE")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date archiveDate;
    @Column(name = "ARCHIVED_BY")
    private String archivedBy;

}
