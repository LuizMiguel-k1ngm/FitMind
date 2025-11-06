package com.fitmind.entity.enums;

public enum ProfileType {
	HEALTHY_MAN(1),
	HEALTHY_WOMEN(2),
	ELDERLY_PERSON(3),
	JOINT_ISSUE_PERSON(4),
	HEART_OR_LUNG_ISSUE_PERSON(5);
	
	private final int code;

    ProfileType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProfileType fromCode(int code) {
        for (ProfileType type : ProfileType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
