// Public class which is at the top of the Strategy Pattern and is used by Offensive and Defensive Mode
public class operationalmode {
	public Destroy DestroyType;
	
	// Operational Mode passes the responsibility for destroy to destroytype
	public String destroyin(){
		return DestroyType.Destroy();
	}
	// To set the destory type dynamically like it says in the spec, this set method must be created
	public void setDestroyingAbilities(Destroy newDestroyType){
		DestroyType = newDestroyType;
	}
}
