package org.xtext.example.videoedit.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.videoedit.services.VideoEditGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVideoEditParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'project'", "'{'", "'}'", "'track'", "'clip'", "'source:'", "'source_in:'", "'source_out:'", "'target_position:'", "'sync_with:'", "'audio_level:'", "'%'", "':'", "'V1'", "'V2'", "'V3'", "'A1'", "'A2'", "'A3'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalVideoEditParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVideoEditParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVideoEditParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVideoEdit.g"; }



     	private VideoEditGrammarAccess grammarAccess;

        public InternalVideoEditParser(TokenStream input, VideoEditGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Project";
       	}

       	@Override
       	protected VideoEditGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProject"
    // InternalVideoEdit.g:65:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalVideoEdit.g:65:48: (iv_ruleProject= ruleProject EOF )
            // InternalVideoEdit.g:66:2: iv_ruleProject= ruleProject EOF
            {
             newCompositeNode(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProject=ruleProject();

            state._fsp--;

             current =iv_ruleProject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalVideoEdit.g:72:1: ruleProject returns [EObject current=null] : (otherlv_0= 'project' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_tracks_3_0= ruleTrack ) )* otherlv_4= '}' ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_tracks_3_0 = null;



        	enterRule();

        try {
            // InternalVideoEdit.g:78:2: ( (otherlv_0= 'project' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_tracks_3_0= ruleTrack ) )* otherlv_4= '}' ) )
            // InternalVideoEdit.g:79:2: (otherlv_0= 'project' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_tracks_3_0= ruleTrack ) )* otherlv_4= '}' )
            {
            // InternalVideoEdit.g:79:2: (otherlv_0= 'project' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_tracks_3_0= ruleTrack ) )* otherlv_4= '}' )
            // InternalVideoEdit.g:80:3: otherlv_0= 'project' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_tracks_3_0= ruleTrack ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getProjectAccess().getProjectKeyword_0());
            		
            // InternalVideoEdit.g:84:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalVideoEdit.g:85:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalVideoEdit.g:85:4: (lv_name_1_0= RULE_STRING )
            // InternalVideoEdit.g:86:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getProjectAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProjectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalVideoEdit.g:106:3: ( (lv_tracks_3_0= ruleTrack ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalVideoEdit.g:107:4: (lv_tracks_3_0= ruleTrack )
            	    {
            	    // InternalVideoEdit.g:107:4: (lv_tracks_3_0= ruleTrack )
            	    // InternalVideoEdit.g:108:5: lv_tracks_3_0= ruleTrack
            	    {

            	    					newCompositeNode(grammarAccess.getProjectAccess().getTracksTrackParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_tracks_3_0=ruleTrack();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProjectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tracks",
            	    						lv_tracks_3_0,
            	    						"org.xtext.example.videoedit.VideoEdit.Track");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleTrack"
    // InternalVideoEdit.g:133:1: entryRuleTrack returns [EObject current=null] : iv_ruleTrack= ruleTrack EOF ;
    public final EObject entryRuleTrack() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrack = null;


        try {
            // InternalVideoEdit.g:133:46: (iv_ruleTrack= ruleTrack EOF )
            // InternalVideoEdit.g:134:2: iv_ruleTrack= ruleTrack EOF
            {
             newCompositeNode(grammarAccess.getTrackRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrack=ruleTrack();

            state._fsp--;

             current =iv_ruleTrack; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrack"


    // $ANTLR start "ruleTrack"
    // InternalVideoEdit.g:140:1: ruleTrack returns [EObject current=null] : (otherlv_0= 'track' ( (lv_type_1_0= ruleTrackType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_clips_4_0= ruleClip ) )* otherlv_5= '}' ) ;
    public final EObject ruleTrack() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_clips_4_0 = null;



        	enterRule();

        try {
            // InternalVideoEdit.g:146:2: ( (otherlv_0= 'track' ( (lv_type_1_0= ruleTrackType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_clips_4_0= ruleClip ) )* otherlv_5= '}' ) )
            // InternalVideoEdit.g:147:2: (otherlv_0= 'track' ( (lv_type_1_0= ruleTrackType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_clips_4_0= ruleClip ) )* otherlv_5= '}' )
            {
            // InternalVideoEdit.g:147:2: (otherlv_0= 'track' ( (lv_type_1_0= ruleTrackType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_clips_4_0= ruleClip ) )* otherlv_5= '}' )
            // InternalVideoEdit.g:148:3: otherlv_0= 'track' ( (lv_type_1_0= ruleTrackType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_clips_4_0= ruleClip ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getTrackAccess().getTrackKeyword_0());
            		
            // InternalVideoEdit.g:152:3: ( (lv_type_1_0= ruleTrackType ) )
            // InternalVideoEdit.g:153:4: (lv_type_1_0= ruleTrackType )
            {
            // InternalVideoEdit.g:153:4: (lv_type_1_0= ruleTrackType )
            // InternalVideoEdit.g:154:5: lv_type_1_0= ruleTrackType
            {

            					newCompositeNode(grammarAccess.getTrackAccess().getTypeTrackTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_type_1_0=ruleTrackType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTrackRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.xtext.example.videoedit.VideoEdit.TrackType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalVideoEdit.g:171:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalVideoEdit.g:172:4: (lv_name_2_0= RULE_ID )
            {
            // InternalVideoEdit.g:172:4: (lv_name_2_0= RULE_ID )
            // InternalVideoEdit.g:173:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTrackAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTrackRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getTrackAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalVideoEdit.g:193:3: ( (lv_clips_4_0= ruleClip ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalVideoEdit.g:194:4: (lv_clips_4_0= ruleClip )
            	    {
            	    // InternalVideoEdit.g:194:4: (lv_clips_4_0= ruleClip )
            	    // InternalVideoEdit.g:195:5: lv_clips_4_0= ruleClip
            	    {

            	    					newCompositeNode(grammarAccess.getTrackAccess().getClipsClipParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_clips_4_0=ruleClip();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTrackRule());
            	    					}
            	    					add(
            	    						current,
            	    						"clips",
            	    						lv_clips_4_0,
            	    						"org.xtext.example.videoedit.VideoEdit.Clip");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTrackAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrack"


    // $ANTLR start "entryRuleClip"
    // InternalVideoEdit.g:220:1: entryRuleClip returns [EObject current=null] : iv_ruleClip= ruleClip EOF ;
    public final EObject entryRuleClip() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClip = null;


        try {
            // InternalVideoEdit.g:220:45: (iv_ruleClip= ruleClip EOF )
            // InternalVideoEdit.g:221:2: iv_ruleClip= ruleClip EOF
            {
             newCompositeNode(grammarAccess.getClipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClip=ruleClip();

            state._fsp--;

             current =iv_ruleClip; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClip"


    // $ANTLR start "ruleClip"
    // InternalVideoEdit.g:227:1: ruleClip returns [EObject current=null] : (otherlv_0= 'clip' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= RULE_STRING ) ) otherlv_5= 'source_in:' ( (lv_sourceIn_6_0= ruleTimeCode ) ) otherlv_7= 'source_out:' ( (lv_sourceOut_8_0= ruleTimeCode ) ) otherlv_9= 'target_position:' ( (lv_targetPosition_10_0= ruleTimeCode ) ) ( (lv_audioLevel_11_0= ruleAudioLevel ) )? (otherlv_12= 'sync_with:' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= '}' ) ;
    public final EObject ruleClip() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_source_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        EObject lv_sourceIn_6_0 = null;

        EObject lv_sourceOut_8_0 = null;

        EObject lv_targetPosition_10_0 = null;

        EObject lv_audioLevel_11_0 = null;



        	enterRule();

        try {
            // InternalVideoEdit.g:233:2: ( (otherlv_0= 'clip' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= RULE_STRING ) ) otherlv_5= 'source_in:' ( (lv_sourceIn_6_0= ruleTimeCode ) ) otherlv_7= 'source_out:' ( (lv_sourceOut_8_0= ruleTimeCode ) ) otherlv_9= 'target_position:' ( (lv_targetPosition_10_0= ruleTimeCode ) ) ( (lv_audioLevel_11_0= ruleAudioLevel ) )? (otherlv_12= 'sync_with:' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= '}' ) )
            // InternalVideoEdit.g:234:2: (otherlv_0= 'clip' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= RULE_STRING ) ) otherlv_5= 'source_in:' ( (lv_sourceIn_6_0= ruleTimeCode ) ) otherlv_7= 'source_out:' ( (lv_sourceOut_8_0= ruleTimeCode ) ) otherlv_9= 'target_position:' ( (lv_targetPosition_10_0= ruleTimeCode ) ) ( (lv_audioLevel_11_0= ruleAudioLevel ) )? (otherlv_12= 'sync_with:' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= '}' )
            {
            // InternalVideoEdit.g:234:2: (otherlv_0= 'clip' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= RULE_STRING ) ) otherlv_5= 'source_in:' ( (lv_sourceIn_6_0= ruleTimeCode ) ) otherlv_7= 'source_out:' ( (lv_sourceOut_8_0= ruleTimeCode ) ) otherlv_9= 'target_position:' ( (lv_targetPosition_10_0= ruleTimeCode ) ) ( (lv_audioLevel_11_0= ruleAudioLevel ) )? (otherlv_12= 'sync_with:' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= '}' )
            // InternalVideoEdit.g:235:3: otherlv_0= 'clip' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= RULE_STRING ) ) otherlv_5= 'source_in:' ( (lv_sourceIn_6_0= ruleTimeCode ) ) otherlv_7= 'source_out:' ( (lv_sourceOut_8_0= ruleTimeCode ) ) otherlv_9= 'target_position:' ( (lv_targetPosition_10_0= ruleTimeCode ) ) ( (lv_audioLevel_11_0= ruleAudioLevel ) )? (otherlv_12= 'sync_with:' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getClipAccess().getClipKeyword_0());
            		
            // InternalVideoEdit.g:239:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalVideoEdit.g:240:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalVideoEdit.g:240:4: (lv_name_1_0= RULE_STRING )
            // InternalVideoEdit.g:241:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getClipAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getClipAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getClipAccess().getSourceKeyword_3());
            		
            // InternalVideoEdit.g:265:3: ( (lv_source_4_0= RULE_STRING ) )
            // InternalVideoEdit.g:266:4: (lv_source_4_0= RULE_STRING )
            {
            // InternalVideoEdit.g:266:4: (lv_source_4_0= RULE_STRING )
            // InternalVideoEdit.g:267:5: lv_source_4_0= RULE_STRING
            {
            lv_source_4_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_source_4_0, grammarAccess.getClipAccess().getSourceSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"source",
            						lv_source_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_11); 

            			newLeafNode(otherlv_5, grammarAccess.getClipAccess().getSource_inKeyword_5());
            		
            // InternalVideoEdit.g:287:3: ( (lv_sourceIn_6_0= ruleTimeCode ) )
            // InternalVideoEdit.g:288:4: (lv_sourceIn_6_0= ruleTimeCode )
            {
            // InternalVideoEdit.g:288:4: (lv_sourceIn_6_0= ruleTimeCode )
            // InternalVideoEdit.g:289:5: lv_sourceIn_6_0= ruleTimeCode
            {

            					newCompositeNode(grammarAccess.getClipAccess().getSourceInTimeCodeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_12);
            lv_sourceIn_6_0=ruleTimeCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClipRule());
            					}
            					set(
            						current,
            						"sourceIn",
            						lv_sourceIn_6_0,
            						"org.xtext.example.videoedit.VideoEdit.TimeCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_7, grammarAccess.getClipAccess().getSource_outKeyword_7());
            		
            // InternalVideoEdit.g:310:3: ( (lv_sourceOut_8_0= ruleTimeCode ) )
            // InternalVideoEdit.g:311:4: (lv_sourceOut_8_0= ruleTimeCode )
            {
            // InternalVideoEdit.g:311:4: (lv_sourceOut_8_0= ruleTimeCode )
            // InternalVideoEdit.g:312:5: lv_sourceOut_8_0= ruleTimeCode
            {

            					newCompositeNode(grammarAccess.getClipAccess().getSourceOutTimeCodeParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_13);
            lv_sourceOut_8_0=ruleTimeCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClipRule());
            					}
            					set(
            						current,
            						"sourceOut",
            						lv_sourceOut_8_0,
            						"org.xtext.example.videoedit.VideoEdit.TimeCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,19,FOLLOW_11); 

            			newLeafNode(otherlv_9, grammarAccess.getClipAccess().getTarget_positionKeyword_9());
            		
            // InternalVideoEdit.g:333:3: ( (lv_targetPosition_10_0= ruleTimeCode ) )
            // InternalVideoEdit.g:334:4: (lv_targetPosition_10_0= ruleTimeCode )
            {
            // InternalVideoEdit.g:334:4: (lv_targetPosition_10_0= ruleTimeCode )
            // InternalVideoEdit.g:335:5: lv_targetPosition_10_0= ruleTimeCode
            {

            					newCompositeNode(grammarAccess.getClipAccess().getTargetPositionTimeCodeParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_14);
            lv_targetPosition_10_0=ruleTimeCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClipRule());
            					}
            					set(
            						current,
            						"targetPosition",
            						lv_targetPosition_10_0,
            						"org.xtext.example.videoedit.VideoEdit.TimeCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalVideoEdit.g:352:3: ( (lv_audioLevel_11_0= ruleAudioLevel ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==21) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalVideoEdit.g:353:4: (lv_audioLevel_11_0= ruleAudioLevel )
                    {
                    // InternalVideoEdit.g:353:4: (lv_audioLevel_11_0= ruleAudioLevel )
                    // InternalVideoEdit.g:354:5: lv_audioLevel_11_0= ruleAudioLevel
                    {

                    					newCompositeNode(grammarAccess.getClipAccess().getAudioLevelAudioLevelParserRuleCall_11_0());
                    				
                    pushFollow(FOLLOW_15);
                    lv_audioLevel_11_0=ruleAudioLevel();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getClipRule());
                    					}
                    					set(
                    						current,
                    						"audioLevel",
                    						lv_audioLevel_11_0,
                    						"org.xtext.example.videoedit.VideoEdit.AudioLevel");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalVideoEdit.g:371:3: (otherlv_12= 'sync_with:' ( (otherlv_13= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalVideoEdit.g:372:4: otherlv_12= 'sync_with:' ( (otherlv_13= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getClipAccess().getSync_withKeyword_12_0());
                    			
                    // InternalVideoEdit.g:376:4: ( (otherlv_13= RULE_STRING ) )
                    // InternalVideoEdit.g:377:5: (otherlv_13= RULE_STRING )
                    {
                    // InternalVideoEdit.g:377:5: (otherlv_13= RULE_STRING )
                    // InternalVideoEdit.g:378:6: otherlv_13= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClipRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_STRING,FOLLOW_16); 

                    						newLeafNode(otherlv_13, grammarAccess.getClipAccess().getSyncWithClipCrossReference_12_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getClipAccess().getRightCurlyBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClip"


    // $ANTLR start "entryRuleAudioLevel"
    // InternalVideoEdit.g:398:1: entryRuleAudioLevel returns [EObject current=null] : iv_ruleAudioLevel= ruleAudioLevel EOF ;
    public final EObject entryRuleAudioLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAudioLevel = null;


        try {
            // InternalVideoEdit.g:398:51: (iv_ruleAudioLevel= ruleAudioLevel EOF )
            // InternalVideoEdit.g:399:2: iv_ruleAudioLevel= ruleAudioLevel EOF
            {
             newCompositeNode(grammarAccess.getAudioLevelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAudioLevel=ruleAudioLevel();

            state._fsp--;

             current =iv_ruleAudioLevel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAudioLevel"


    // $ANTLR start "ruleAudioLevel"
    // InternalVideoEdit.g:405:1: ruleAudioLevel returns [EObject current=null] : (otherlv_0= 'audio_level:' ( (lv_level_1_0= RULE_INT ) ) otherlv_2= '%' ) ;
    public final EObject ruleAudioLevel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_level_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalVideoEdit.g:411:2: ( (otherlv_0= 'audio_level:' ( (lv_level_1_0= RULE_INT ) ) otherlv_2= '%' ) )
            // InternalVideoEdit.g:412:2: (otherlv_0= 'audio_level:' ( (lv_level_1_0= RULE_INT ) ) otherlv_2= '%' )
            {
            // InternalVideoEdit.g:412:2: (otherlv_0= 'audio_level:' ( (lv_level_1_0= RULE_INT ) ) otherlv_2= '%' )
            // InternalVideoEdit.g:413:3: otherlv_0= 'audio_level:' ( (lv_level_1_0= RULE_INT ) ) otherlv_2= '%'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getAudioLevelAccess().getAudio_levelKeyword_0());
            		
            // InternalVideoEdit.g:417:3: ( (lv_level_1_0= RULE_INT ) )
            // InternalVideoEdit.g:418:4: (lv_level_1_0= RULE_INT )
            {
            // InternalVideoEdit.g:418:4: (lv_level_1_0= RULE_INT )
            // InternalVideoEdit.g:419:5: lv_level_1_0= RULE_INT
            {
            lv_level_1_0=(Token)match(input,RULE_INT,FOLLOW_17); 

            					newLeafNode(lv_level_1_0, grammarAccess.getAudioLevelAccess().getLevelINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAudioLevelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"level",
            						lv_level_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getAudioLevelAccess().getPercentSignKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAudioLevel"


    // $ANTLR start "entryRuleTimeCode"
    // InternalVideoEdit.g:443:1: entryRuleTimeCode returns [EObject current=null] : iv_ruleTimeCode= ruleTimeCode EOF ;
    public final EObject entryRuleTimeCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeCode = null;


        try {
            // InternalVideoEdit.g:443:49: (iv_ruleTimeCode= ruleTimeCode EOF )
            // InternalVideoEdit.g:444:2: iv_ruleTimeCode= ruleTimeCode EOF
            {
             newCompositeNode(grammarAccess.getTimeCodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeCode=ruleTimeCode();

            state._fsp--;

             current =iv_ruleTimeCode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeCode"


    // $ANTLR start "ruleTimeCode"
    // InternalVideoEdit.g:450:1: ruleTimeCode returns [EObject current=null] : ( ( (lv_hours_0_0= RULE_INT ) ) otherlv_1= ':' ( (lv_minutes_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_seconds_4_0= RULE_INT ) ) otherlv_5= ':' ( (lv_frames_6_0= RULE_INT ) ) ) ;
    public final EObject ruleTimeCode() throws RecognitionException {
        EObject current = null;

        Token lv_hours_0_0=null;
        Token otherlv_1=null;
        Token lv_minutes_2_0=null;
        Token otherlv_3=null;
        Token lv_seconds_4_0=null;
        Token otherlv_5=null;
        Token lv_frames_6_0=null;


        	enterRule();

        try {
            // InternalVideoEdit.g:456:2: ( ( ( (lv_hours_0_0= RULE_INT ) ) otherlv_1= ':' ( (lv_minutes_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_seconds_4_0= RULE_INT ) ) otherlv_5= ':' ( (lv_frames_6_0= RULE_INT ) ) ) )
            // InternalVideoEdit.g:457:2: ( ( (lv_hours_0_0= RULE_INT ) ) otherlv_1= ':' ( (lv_minutes_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_seconds_4_0= RULE_INT ) ) otherlv_5= ':' ( (lv_frames_6_0= RULE_INT ) ) )
            {
            // InternalVideoEdit.g:457:2: ( ( (lv_hours_0_0= RULE_INT ) ) otherlv_1= ':' ( (lv_minutes_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_seconds_4_0= RULE_INT ) ) otherlv_5= ':' ( (lv_frames_6_0= RULE_INT ) ) )
            // InternalVideoEdit.g:458:3: ( (lv_hours_0_0= RULE_INT ) ) otherlv_1= ':' ( (lv_minutes_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_seconds_4_0= RULE_INT ) ) otherlv_5= ':' ( (lv_frames_6_0= RULE_INT ) )
            {
            // InternalVideoEdit.g:458:3: ( (lv_hours_0_0= RULE_INT ) )
            // InternalVideoEdit.g:459:4: (lv_hours_0_0= RULE_INT )
            {
            // InternalVideoEdit.g:459:4: (lv_hours_0_0= RULE_INT )
            // InternalVideoEdit.g:460:5: lv_hours_0_0= RULE_INT
            {
            lv_hours_0_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_hours_0_0, grammarAccess.getTimeCodeAccess().getHoursINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeCodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"hours",
            						lv_hours_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeCodeAccess().getColonKeyword_1());
            		
            // InternalVideoEdit.g:480:3: ( (lv_minutes_2_0= RULE_INT ) )
            // InternalVideoEdit.g:481:4: (lv_minutes_2_0= RULE_INT )
            {
            // InternalVideoEdit.g:481:4: (lv_minutes_2_0= RULE_INT )
            // InternalVideoEdit.g:482:5: lv_minutes_2_0= RULE_INT
            {
            lv_minutes_2_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_minutes_2_0, grammarAccess.getTimeCodeAccess().getMinutesINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeCodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"minutes",
            						lv_minutes_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getTimeCodeAccess().getColonKeyword_3());
            		
            // InternalVideoEdit.g:502:3: ( (lv_seconds_4_0= RULE_INT ) )
            // InternalVideoEdit.g:503:4: (lv_seconds_4_0= RULE_INT )
            {
            // InternalVideoEdit.g:503:4: (lv_seconds_4_0= RULE_INT )
            // InternalVideoEdit.g:504:5: lv_seconds_4_0= RULE_INT
            {
            lv_seconds_4_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_seconds_4_0, grammarAccess.getTimeCodeAccess().getSecondsINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeCodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"seconds",
            						lv_seconds_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_11); 

            			newLeafNode(otherlv_5, grammarAccess.getTimeCodeAccess().getColonKeyword_5());
            		
            // InternalVideoEdit.g:524:3: ( (lv_frames_6_0= RULE_INT ) )
            // InternalVideoEdit.g:525:4: (lv_frames_6_0= RULE_INT )
            {
            // InternalVideoEdit.g:525:4: (lv_frames_6_0= RULE_INT )
            // InternalVideoEdit.g:526:5: lv_frames_6_0= RULE_INT
            {
            lv_frames_6_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_frames_6_0, grammarAccess.getTimeCodeAccess().getFramesINTTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeCodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"frames",
            						lv_frames_6_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeCode"


    // $ANTLR start "ruleTrackType"
    // InternalVideoEdit.g:546:1: ruleTrackType returns [Enumerator current=null] : ( (enumLiteral_0= 'V1' ) | (enumLiteral_1= 'V2' ) | (enumLiteral_2= 'V3' ) | (enumLiteral_3= 'A1' ) | (enumLiteral_4= 'A2' ) | (enumLiteral_5= 'A3' ) ) ;
    public final Enumerator ruleTrackType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalVideoEdit.g:552:2: ( ( (enumLiteral_0= 'V1' ) | (enumLiteral_1= 'V2' ) | (enumLiteral_2= 'V3' ) | (enumLiteral_3= 'A1' ) | (enumLiteral_4= 'A2' ) | (enumLiteral_5= 'A3' ) ) )
            // InternalVideoEdit.g:553:2: ( (enumLiteral_0= 'V1' ) | (enumLiteral_1= 'V2' ) | (enumLiteral_2= 'V3' ) | (enumLiteral_3= 'A1' ) | (enumLiteral_4= 'A2' ) | (enumLiteral_5= 'A3' ) )
            {
            // InternalVideoEdit.g:553:2: ( (enumLiteral_0= 'V1' ) | (enumLiteral_1= 'V2' ) | (enumLiteral_2= 'V3' ) | (enumLiteral_3= 'A1' ) | (enumLiteral_4= 'A2' ) | (enumLiteral_5= 'A3' ) )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt5=1;
                }
                break;
            case 25:
                {
                alt5=2;
                }
                break;
            case 26:
                {
                alt5=3;
                }
                break;
            case 27:
                {
                alt5=4;
                }
                break;
            case 28:
                {
                alt5=5;
                }
                break;
            case 29:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalVideoEdit.g:554:3: (enumLiteral_0= 'V1' )
                    {
                    // InternalVideoEdit.g:554:3: (enumLiteral_0= 'V1' )
                    // InternalVideoEdit.g:555:4: enumLiteral_0= 'V1'
                    {
                    enumLiteral_0=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getTrackTypeAccess().getV1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTrackTypeAccess().getV1EnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalVideoEdit.g:562:3: (enumLiteral_1= 'V2' )
                    {
                    // InternalVideoEdit.g:562:3: (enumLiteral_1= 'V2' )
                    // InternalVideoEdit.g:563:4: enumLiteral_1= 'V2'
                    {
                    enumLiteral_1=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getTrackTypeAccess().getV2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTrackTypeAccess().getV2EnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalVideoEdit.g:570:3: (enumLiteral_2= 'V3' )
                    {
                    // InternalVideoEdit.g:570:3: (enumLiteral_2= 'V3' )
                    // InternalVideoEdit.g:571:4: enumLiteral_2= 'V3'
                    {
                    enumLiteral_2=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getTrackTypeAccess().getV3EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTrackTypeAccess().getV3EnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalVideoEdit.g:578:3: (enumLiteral_3= 'A1' )
                    {
                    // InternalVideoEdit.g:578:3: (enumLiteral_3= 'A1' )
                    // InternalVideoEdit.g:579:4: enumLiteral_3= 'A1'
                    {
                    enumLiteral_3=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getTrackTypeAccess().getA1EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getTrackTypeAccess().getA1EnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalVideoEdit.g:586:3: (enumLiteral_4= 'A2' )
                    {
                    // InternalVideoEdit.g:586:3: (enumLiteral_4= 'A2' )
                    // InternalVideoEdit.g:587:4: enumLiteral_4= 'A2'
                    {
                    enumLiteral_4=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getTrackTypeAccess().getA2EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getTrackTypeAccess().getA2EnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalVideoEdit.g:594:3: (enumLiteral_5= 'A3' )
                    {
                    // InternalVideoEdit.g:594:3: (enumLiteral_5= 'A3' )
                    // InternalVideoEdit.g:595:4: enumLiteral_5= 'A3'
                    {
                    enumLiteral_5=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getTrackTypeAccess().getA3EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getTrackTypeAccess().getA3EnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrackType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000003F000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000302000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});

}