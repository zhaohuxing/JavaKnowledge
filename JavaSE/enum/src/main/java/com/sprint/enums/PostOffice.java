package com.sprint.enums;

public class PostOffice {
	enum MailHandler {
		//在enum中必须是实例打头
		GENERAL_DELIVERY {
			boolean handle(Mail m) {
				switch (m.generalDelivery) {
					case YES: 
						System.out.println("Using general delivery for " + m);
						return true;
					default:
						return false;
				}
			}
		},

		MACHINE_SCAN {
			boolean handle(Mail m) {
				switch (m.scannablity) {
					case UNSCANNABLE:
						return false;
					default:
						System.out.println("Delivering " + m + " automatically");
						return true;
				}
			}
		},

		VISUAL_INSPECTION {
			boolean handle(Mail m) {
				switch (m.readablity) {
					case ILLEGILE: return false;
					default:
						System.out.println("Delivering" + m + " normally");
						return true;
				}
			}
		},

		RETURN_TO_SENDER {
			boolean handle(Mail m) {
				switch (m.returnAddress) {
					case MISSING: return false;
					default:
						System.out.println("Returing " + m + " to sender");
						return true;
				}
			}
		};
		abstract boolean handle(Mail m);
	}

	public static void handle(Mail m) {
		for (MailHandler handler : MailHandler.values()) {
			if (handler.handle(m))
				return;
			System.out.print(m + " is a dead letter");
		}
	}
}
