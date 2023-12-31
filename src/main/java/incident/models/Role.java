package incident.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SC_ROLES", schema = "MTS_SECURITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	@Id
	private Long ROLE_ID;
	private String ROLE_NAME;
	private Long PARENT_ROLE_ID;
	private String LAST_MODIFIED_BY;
//	private String DESCRIPTION;

}
